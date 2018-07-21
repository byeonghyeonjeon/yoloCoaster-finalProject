/**
 * 
 */
package com.yolo.yolo.service.google;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.jsp.PageContext;

import org.apache.tiles.request.Request;
import org.junit.Test;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.SafeSearchAnnotation;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.protobuf.ByteString;
import com.yolo.service.admin.ImageFilterServiceInf;

/**
 * @author PC15
 *
 */
public class ImageFilterServiceTest {

	@Resource
	private ImageFilterServiceInf imageFilterService;

	@Test
	public void ImageFilterTest() throws IOException {

		String imgPath = "C:/Users/PC15/Pictures/help.jpg";

		String imagePathList_2 = imageFilterService.imageFiltering(imgPath);

		assertNotNull(imagePathList_2);
	}

	@Test
	public void jsonTest() throws Exception {
		List<String> imagePathList = new ArrayList<String>();
		
		/* String pathName ="C:/Users/PC15/Pictures/help.jpg"; */
		String pathName = "/image/logo/help.jpg";
		
		

		/* imagePathList.add("/image/logo/yehlee.jpg"); */
		/** given **/
		final String PROJECTPATH = "D:/A_TeachingMaterial/8.LastProject/workspace/yoloCoaster/src/main/webapp";		
		
		/** when **/
		// Instantiates a client
		try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {

			// The path to the image file to annotate
			String fileName = PROJECTPATH + pathName;

			// Reads the image file into memory
			Path path = Paths.get(fileName);
			byte[] data = Files.readAllBytes(path);
			ByteString imgBytes = ByteString.copyFrom(data);

			// Builds the image annotation request
			List<AnnotateImageRequest> requests = new ArrayList<>();
			Image img = Image.newBuilder().setContent(imgBytes).build();
			Feature feat = Feature.newBuilder()
					.setType(Type.SAFE_SEARCH_DETECTION).build();
			AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
					.addFeatures(feat).setImage(img).build();
			requests.add(request);

			// Performs label detection on the image file
			BatchAnnotateImagesResponse response = vision
					.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();

			for (AnnotateImageResponse res : responses) {
				if (res.hasError()) {
					System.out.println("error");
					System.out.printf("Error: %s\n", res.getError()
							.getMessage());
					return; // null
				}

				// feat의 타입에 맞게 Annotation을 설정해야한다.
				// https://cloud.google.com/vision/docs/detecting-safe-search?hl=ko
				SafeSearchAnnotation annotation = res.getSafeSearchAnnotation();

				System.out.println("hi");
				System.out.println(annotation.getAdult());
				System.out.println(annotation.getMedical());
				System.out.println(annotation.getSpoof());
				System.out.println(annotation.getViolence());
				System.out.println(annotation.getRacy());

				assertEquals("UNLIKELY", annotation.getAdult());
			}
		}

	}
	
	
	@Test
	public void jsonDaTest() throws Exception {
		List<String> imagePathList = new ArrayList<String>();
		
		/* String pathName ="C:/Users/PC15/Pictures/help.jpg"; */
		imagePathList.add("/image/logo/help.jpg");
		imagePathList.add("/image/logo/yehlee.jpg");
		
		

		/* imagePathList.add("/image/logo/yehlee.jpg"); */
		/** given **/
		final String PROJECTPATH = "D:/A_TeachingMaterial/8.LastProject/workspace/yoloCoaster/src/main/webapp";		
	
		for(String path : imagePathList){
			
			/** when **/
			// Instantiates a client
			try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {
				
				// The path to the image file to annotate
				String fileName = PROJECTPATH + path;
				
				// Reads the image file into memory
				Path path1 = Paths.get(fileName);
				byte[] data = Files.readAllBytes(path1);
				ByteString imgBytes = ByteString.copyFrom(data);
				
				// Builds the image annotation request
				List<AnnotateImageRequest> requests = new ArrayList<>();
				Image img = Image.newBuilder().setContent(imgBytes).build();
				Feature feat = Feature.newBuilder()
						.setType(Type.SAFE_SEARCH_DETECTION).build();
				AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
						.addFeatures(feat).setImage(img).build();
				requests.add(request);
				
				// Performs label detection on the image file
				BatchAnnotateImagesResponse response = vision
						.batchAnnotateImages(requests);
				List<AnnotateImageResponse> responses = response.getResponsesList();
				
				for (AnnotateImageResponse res : responses) {
					if (res.hasError()) {
						System.out.println("error");
						System.out.printf("Error: %s\n", res.getError()
								.getMessage());
						return; // null
					}
					
					// feat의 타입에 맞게 Annotation을 설정해야한다.
					// https://cloud.google.com/vision/docs/detecting-safe-search?hl=ko
					SafeSearchAnnotation annotation = res.getSafeSearchAnnotation();
					
					System.out.println("hi");
					System.out.println(annotation.getAdult());
					System.out.println(annotation.getMedical());
					System.out.println(annotation.getSpoof());
					System.out.println(annotation.getViolence());
					System.out.println(annotation.getRacy());
					
					assertEquals("UNLIKELY", annotation.getAdult().name());
				}
			}
		}

	}


}
