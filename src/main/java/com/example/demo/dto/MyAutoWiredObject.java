package com.example.demo.dto;

import java.util.HashMap;
import java.util.Map;

public class MyAutoWiredObject {

    String key;
    String value;

    public Map<String, Person> objectMap=null;

   public MyAutoWiredObject( String key,String value )
   {
       this.key=key;
       this.value=value;

       objectMap = new HashMap<String, Person>();
   }
}
