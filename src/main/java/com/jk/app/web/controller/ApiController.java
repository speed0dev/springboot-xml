package com.jk.app.web.controller;

import com.jk.app.web.dto.ParamXml;
import com.jk.app.web.dto.ResDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

// TODO 참조 한 부분
// https://ryan-han.com/post/java/xml_to_java_object/

@RestController
public class ApiController {

    @GetMapping("/api/call")
    public String getCall(){
        System.out.println("#################");
        System.out.println("#################");
        System.out.println("#################");
        System.out.println("#################");

        return "RRRRRRRRRRRR";
    }

    @GetMapping("/api/callB")
    public String getCallB(){

        return "RRRRRRRRRRRR";
    }


    //------------------------------
    //
    @PostMapping(value = "/api/xml",
            consumes = {MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResDto getXml(HttpServletRequest req, HttpServletResponse res) throws Exception{     //

        System.out.println("==========================================");
        System.out.println(" req:" + req.toString());

        System.out.println("==========================================");

        BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String buffer;
        while ((buffer = input.readLine()) != null) {
            if (builder.length() > 0) {
                //builder.append("\n");
            }
            builder.append(buffer);
        }

        System.out.println( builder.toString() );

        //--------------
        //
        JAXBContext jaxbContext = JAXBContext.newInstance(ParamXml.class);          // JAXB Context 생성
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();               // Unmarshaller Object 생성
        ParamXml paramXml = (ParamXml) unmarshaller.unmarshal(new StringReader(builder.toString()));    //

        System.out.println("------------------------------------------");
        System.out.println(paramXml.toString());
        System.out.println("------------------------------------------");

        //JAXBContext jaxbContext = JAXBContext.newInstance(res.class); // JAXB Context 생성
        //Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        //return builder.toString();



        ResDto dto = new ResDto();
        dto.setName("FFFFFFFFFFFFFFFFFFFFFFFF");

        //return new ResponseEntity<>(tutorials, HttpStatus.OK);

        return dto;

    }






}
