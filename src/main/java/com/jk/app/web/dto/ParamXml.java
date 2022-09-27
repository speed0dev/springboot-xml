package com.jk.app.web.dto;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.xml.bind.annotation.*;

@Data
//@Getter
//@Setter
//@ToString
//@JacksonXmlRootElement(localName = "paramXml")
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
//@XmlAccessorType(XmlAccessType.FIELD)
public class ParamXml {

    @XmlElement(name="name")
    private String name;

    @XmlElement(name="code")
    private String code;

    @XmlElement(name="test")
    private String test;

    @XmlElement(name="bTag")
    private boolean bTag;


}
