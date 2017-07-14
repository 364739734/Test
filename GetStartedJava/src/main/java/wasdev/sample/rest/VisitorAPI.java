/*******************************************************************************
 * Copyright (c) 2017 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/ 
package wasdev.sample.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import com.google.gson.Gson;

import wasdev.sample.Visitor;
import wasdev.sample.store.VisitorStore;
import wasdev.sample.store.VisitorStoreFactory;

@ApplicationPath("api")
@Path("/visitors")
public class VisitorAPI extends Application {
	
	//Our database store
	VisitorStore store = VisitorStoreFactory.getInstance();

    @GET
    @Path("/")
    @Produces({"application/json"})
    public String getVisitors() {
    	String userId = "18eb9afd-720f-40d1-bbfc-a080fe30ab8e";
    	String password = "7tcJ0X3XYEnN";
    	String uuid = "e4969a51-9e44-4b56-8d19-5cafc7c9a60a";
//    	
//    	ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2017_02_03);
//		service.setUsernameAndPassword(userId, password);
//		MessageRequest newMessage = new MessageRequest.Builder().inputText("").build();
//		MessageResponse response = service.message(uuid, newMessage).execute();
//		
		return new Gson().toJson(null);
    }
    
    @POST
    @Produces("application/text")
    @Consumes("application/json")
    public String newToDo(Visitor visitor) {
      if(store == null) {
    	  return String.format("Hello %s!", visitor.getName());
      }
      store.persist(visitor);
      return String.format("Hello %s! I've added you to the database.", visitor.getName());

    }

}