package com.example.demo.service;

import com.example.demo.dto.MyAutoWiredObject;
import com.example.demo.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestService {

    @Autowired
    MyAutoWiredObject object;


    public void persist(Person p)
    {
       if(object.objectMap.containsKey(p.getId()))
       {
           throw new BadRequestException("Person already present");
       }

        object.objectMap.put(p.getId(),p);
    }

    public Person getPerson(String id)
    {
        if(!object.objectMap.containsKey(id))
        {
            throw new NotFoundException("Person not found");
        }

       return object.objectMap.get(id);
    }
}
