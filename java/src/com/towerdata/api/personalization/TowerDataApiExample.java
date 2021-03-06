package com.towerdata.api.personalization;
/*
 * Copyright 2014 TowerData
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TowerDataApiExample {
  public static void main(String[] args) {
    TowerDataApi api = (args.length >= 1 && args[0] != null) ? new TowerDataApi(args[0]):new TowerDataApi("YOUR_API_KEY");
    final String email = (args.length >= 2 && args[1] != null) ? args[1]:"pete@rapleafdemo.com";

    // Query by email
    try {
      JSONObject response = api.queryByEmail(email, false);
      System.out.println("Query by email: \n" + response);
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Bulk Query
    final List<Map<String,String>> list = new ArrayList<Map<String, String>>() {
      {
        add(new HashMap<String, String>(){
          {
            put("email", email);
          }
        });
        add(new HashMap<String, String>(){
          {
            put("email", "pete@rapleafdemo.com");
          }
        });
        add(new HashMap<String, String>(){
          {
            put("first", "Peter");
            put("last", "Schlick");
	          put("street", "112134 Leavenworth Rd.");
            put("city", "San Francisco");
            put("state", "CA");
            put("zip", "21044");
          }
        });
      }
    };

    try {
      JSONArray response = api.bulkQuery(list);
      System.out.println("\nBulk Query: \n"+response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
