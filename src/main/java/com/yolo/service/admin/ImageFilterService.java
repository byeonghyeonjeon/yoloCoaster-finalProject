/**
 * 
 */
package com.yolo.service.admin;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.Likelihood;
import com.google.cloud.vision.v1.SafeSearchAnnotation;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Service;


/**
 * @author PC15
 *
 */			
@Service("imageFilterService")
public class ImageFilterService implements ImageFilterServiceInf {
	

	
	public String imageFiltering(String imgPath) throws IOException {		
		
		String result ="GOOD";
		
		
	    // Instantiates a client
	    try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {	    	
	    	
	    	  // The path to the image file to annotate
	  	      String fileName = imgPath;
	  	      
              //"C:/Users/PC15/Pictures/help.jpg"
	  	      // Reads the image file into memory
	  	      Path path = Paths.get(fileName);
	  	      byte[] data = Files.readAllBytes(path);
	  	      ByteString imgBytes = ByteString.copyFrom(data);

	  	      // Builds the image annotation request
	  	      List<AnnotateImageRequest> requests = new ArrayList<>();
	  	      Image img = Image.newBuilder().setContent(imgBytes).build();
	  	      Feature feat = Feature.newBuilder().setType(Type.SAFE_SEARCH_DETECTION).build();
	  	      AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
	  	          .addFeatures(feat)
	  	          .setImage(img)
	  	          .build();
	  	      requests.add(request);
	  	      
	  	      // Performs label detection on the image file
	  	      BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
	  	      List<AnnotateImageResponse> responses = response.getResponsesList();
	  	    
	  	    for (AnnotateImageResponse res : responses) {
		        if (res.hasError()) {
		          System.out.println("error");
		          System.out.printf("Error: %s\n", res.getError().getMessage());
		          return null; //null
		        }
		        
		        //feat의 타입에 맞게 Annotation을 설정해야한다.
		        //https://cloud.google.com/vision/docs/detecting-safe-search?hl=ko
		        SafeSearchAnnotation annotation =res.getSafeSearchAnnotation();
		        
		        
		        if(annotation.getAdult().name().equals("POSSIBLE")
                   || annotation.getAdult().name().equals("LIKELY")
                   || annotation.getAdult().name().equals("VERY LIKELY")
        		   || annotation.getMedical().name().equals("LIKELY")	
		           || annotation.getMedical().name().equals("VERY LIKELY")
		           || annotation.getSpoof().name().equals("LIKELY") 
        		   || annotation.getSpoof().name().equals("VERY LIKELY")        		   
        		   || annotation.getViolence().name().equals("LIKELY")
        		   || annotation.getViolence().name().equals("VERY LIKELY")
        		   || annotation.getRacy().name().equals("LIKELY")
        		   || annotation.getRacy().name().equals("VERY LIKELY")
        		   ){
		        	result= "BAD";
		        }
		        
//		        System.out.println(annotation.getAdult());
//		        System.out.println(annotation.getMedical());
//		        System.out.println(annotation.getSpoof());
//		        System.out.println(annotation.getViolence());
//		        System.out.println(annotation.getRacy());
//		        
		      }	    		
	    	}
	    
      return result;
	}
	

}
