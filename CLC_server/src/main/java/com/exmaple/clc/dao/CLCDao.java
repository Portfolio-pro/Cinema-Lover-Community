package com.exmaple.clc.dao;

import java.io.File;
import java.io.FileInputStream;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import com.example.clc.clc_server.ClcServerApplication;
import com.exmaple.clc.dto.CLCListDto;
import com.exmaple.clc.dto.CLCMovieDto;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class CLCDao {

	private Firestore db;	
	private String docId;
	
	public CLCDao() {
		try{
			ClassLoader classLoader = ClcServerApplication.class.getClassLoader();
			File file = new File(Objects.requireNonNull(classLoader.getResource("CLCAccountKey.json")).getFile());
			FileInputStream serviceAccount =
					  new FileInputStream(file.getAbsolutePath());
	
					FirebaseOptions options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
					  .build();
	
					FirebaseApp.initializeApp(options);
					
					db = FirestoreClient.getFirestore();
					
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<CLCMovieDto>main(String movie_id, String title, String genres, String runtime, String year, String summary, String image){ //list()에서 파이어베이스 데이터 가져와서 출력하고 게시판 데이터도 출력
		ArrayList<CLCMovieDto>dtos = new ArrayList<CLCMovieDto>();
				
		//react에서 데이터를 파이어베이스에 추가
		Map<String, Object> data = new HashMap<>();
		data.put("movie_id", movie_id);
		data.put("title", title);
		data.put("genres", genres);
		data.put("runtime", runtime);
		data.put("year", year);
		data.put("summary", summary);
		data.put("image", image);

		ApiFuture<DocumentReference> future = db.collection("Movie").add(data);
		
		return dtos;
	}
	
	public CLCMovieDto list_movie(String movieId) throws InterruptedException, ExecutionException {
		CLCMovieDto dto =null;
		
		//asynchronously retrieve all documents
		ApiFuture<QuerySnapshot> future = db.collection("Movie").whereEqualTo("id", movieId).get();
		// future.get() blocks on response
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			String movie_id = document.get("movie_id").toString();
			String title = document.get("title").toString();
			String genres = document.get("genres").toString();
			String runtime = document.get("runtime").toString();
			String year = document.get("year").toString();
			String summary = document.get("summary").toString();
			String image = document.get("image").toString();
			
			dto = new CLCMovieDto(movie_id, title, genres, runtime, year, summary, image);
		}
		
		return dto;		
	}
	
	public ArrayList<CLCListDto>list(String movieId) throws InterruptedException, ExecutionException{
		ArrayList<CLCListDto>dtos=new ArrayList<CLCListDto>();
		
		//asynchronously retrieve all documents
		ApiFuture<QuerySnapshot> future = db.collection("List").whereEqualTo("id", movieId).get();
		// future.get() blocks on response
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			String movie_id = document.get("movie_id").toString();
			String id = document.get("id").toString();
			String password = document.get("password").toString();
			String subject = document.get("subject").toString();
			String rating = document.get("rating").toString();
			String content = document.get("content").toString();
			String register_date = document.get("register_date").toString();
					
			CLCListDto dto = new CLCListDto(movie_id, id, password, subject, rating, content, register_date);
			dtos.add(dto);
		}
		
		return dtos;
	} 
	
	public void write(String movie_id, String id, String password, String rating, String subject, String content) {
		// Create a Map to store the data we want to set
		LocalDateTime localDateTime = LocalDateTime.now();
		Map<String, Object> data = new HashMap<>();
		data.put("movie_id", movie_id); //jdbc에서는 자동으로 숫자가 들어갔는데 Firebase는 넘겨받아야하나?
		data.put("id", id);
		data.put("password", password);
		data.put("subject", subject);
		data.put("rating", rating);
		data.put("content", content);
		data.put("register_date", localDateTime.toString());

		ApiFuture<DocumentReference> future = db.collection("List").add(data);
	}
	
	public CLCMovieDto content_movie(String movieId) throws InterruptedException, ExecutionException {
		CLCMovieDto dto =null;
		
		//asynchronously retrieve all documents
		ApiFuture<QuerySnapshot> future = db.collection("Movie").whereEqualTo("id", movieId).get();
		// future.get() blocks on response
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			String movie_id = document.get("movie_id").toString();
			String title = document.get("title").toString();
			String genres = document.get("genres").toString();
			String runtime = document.get("runtime").toString();
			String year = document.get("year").toString();
			String summary = document.get("summary").toString();
			String image = document.get("image").toString();
			
			dto = new CLCMovieDto(movie_id, title, genres, runtime, year, summary, image);
		}
		
		return dto;		
	}
	
	
	public CLCListDto contentview(String movieId, String userId) throws InterruptedException, ExecutionException {
		CLCListDto dto = null;
		
		//asynchronously retrieve all documents
		ApiFuture<QuerySnapshot> future = db.collection("List").whereEqualTo("movieId", movieId).whereEqualTo("userId",userId).get();
		// future.get() blocks on response
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {	
			String docId = document.getId(); // 이걸 게시글에서 받아서 수정이랑 삭제 누르면 데이터 전달해줘야 하나?
			
			String movie_id = document.get("movie_id").toString();
			String id = document.get("id").toString();
			String password = document.get("password").toString();
			String subject = document.get("subject").toString();
			String rating = document.get("rating").toString();
			String content = document.get("content").toString();
			String register_date = document.get("register_date").toString();
			
			dto = new CLCListDto(movie_id, id, password, subject, rating, content, register_date);
		}		
		
		return dto;		
	}
	
	public void modify(String movie_id, String id, String password, String rating, String subject, String content, String docId) {
		// Create a Map to store the data we want to set		
		LocalDateTime localDateTime = LocalDateTime.now();
		Map<String, Object> data = new HashMap<>();
		data.put("movie_id", movie_id);
		data.put("id", id);
		data.put("password", password);
		data.put("subject", subject);
		data.put("rating", rating);
		data.put("content", content);
		data.put("register_date", localDateTime.toString());

		ApiFuture<WriteResult> future = db.collection("List").document(docId).update(data);
	}
	
	public void delete(String movieId, String userId) { // 사용자가 같은 영화에 리뷰 여러 개 쓰면 다 지워질 듯. 그래서 b_no 가 있는건가?
		ApiFuture<WriteResult> writeResult = db.collection("cities").document(docId).delete();
	}
	
}
