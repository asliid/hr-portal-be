
package com.aslidongez.project.mernis;
//------------------------------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 9.0.1.0
//
// Created by Quasar Development 
//
// This class has been generated for test purposes only and cannot be used in any commercial project.
// To use it in commercial project, you need to generate this class again with Premium account.
// Check https://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
//
// Licence: 0748CD85B25D51C6FB45A167F04462481585527E8FFF12036564B5056076309C431C9A20873A9D95B1835FF2CB0A84FB700607F7A17B1F35639B054DB5E67615
//------------------------------------------------------------------------

import java.util.*;


public class QLMKPSPublicSoap
{
    private String url = "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx";
    private HashMap< String,String> httpHeaders = new HashMap< String,String>();
    private boolean enableLogging = false;
    private String userName=null;
    private String password=null;
    private QLMConnectionProvider connectionProvider=new QLMHttpConnectionProvider();

    public QLMKPSPublicSoap()
    {
    }

    public QLMKPSPublicSoap(String url)
    {
        this.url=url;
    }

    public QLMKPSPublicSoap (String url,QLMConnectionProvider connectionProvider) {
        this.url=url;
        this.connectionProvider=connectionProvider;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, String> getHttpHeaders() {
        return httpHeaders;
    }

    public boolean isLoggingEnabled() {
        return enableLogging;
    }

    public void setLoggingEnabled(boolean enableLogging) {
        this.enableLogging = enableLogging;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    
    protected QLMRequestResultHandler createRequestResultHandler()
    {
        QLMRequestResultHandler handler = new QLMRequestResultHandler(QLMSoapVersion.v1_1);
        return handler;
    }
    
    private org.w3c.dom.Document createTCKimlikNoDogrulaRequest(final Long TCKimlikNo,final String Ad,final String Soyad,final Integer DogumYili,QLMRequestResultHandler __handler) throws java.lang.Exception
    {
        org.w3c.dom.Document __xml=__handler.createEnvelopeXml();
        org.w3c.dom.Element __mainNode=__handler.writeElement("http://tckimlik.nvi.gov.tr/WS","TCKimlikNoDogrula",__xml);
        __handler.getBody().appendChild(__mainNode);

        org.w3c.dom.Element __TCKimlikNoItemElement=__handler.writeElementWithType(TCKimlikNo,Long.class, "TCKimlikNo", "http://tckimlik.nvi.gov.tr/WS", __mainNode, false);
        if(__TCKimlikNoItemElement != null)
        {
            __TCKimlikNoItemElement.setTextContent(TCKimlikNo.toString());
        }

        org.w3c.dom.Element __AdItemElement=__handler.writeElementWithType(Ad,String.class, "Ad", "http://tckimlik.nvi.gov.tr/WS", __mainNode, true);
        if(__AdItemElement != null)
        {
            __AdItemElement.setTextContent(Ad.toString());
        }

        org.w3c.dom.Element __SoyadItemElement=__handler.writeElementWithType(Soyad,String.class, "Soyad", "http://tckimlik.nvi.gov.tr/WS", __mainNode, true);
        if(__SoyadItemElement != null)
        {
            __SoyadItemElement.setTextContent(Soyad.toString());
        }

        org.w3c.dom.Element __DogumYiliItemElement=__handler.writeElementWithType(DogumYili,Integer.class, "DogumYili", "http://tckimlik.nvi.gov.tr/WS", __mainNode, false);
        if(__DogumYiliItemElement != null)
        {
            __DogumYiliItemElement.setTextContent(DogumYili.toString());
        }
        __handler.finishEnvelopeXml(__xml);
        return __xml;
    }
    
    public Boolean TCKimlikNoDogrula(final Long TCKimlikNo,final String Ad,final String Soyad,final Integer DogumYili) throws java.lang.Exception
    {
        QLMRequestResultHandler __handler =createRequestResultHandler();
        org.w3c.dom.Document __xml=createTCKimlikNoDogrulaRequest(TCKimlikNo, Ad, Soyad, DogumYili, __handler);
        sendRequest("http://tckimlik.nvi.gov.tr/WS/TCKimlikNoDogrula",__xml,__handler);
        org.w3c.dom.Node __result=QLMHelper.getResult(__handler.getOutputBody(), "TCKimlikNoDogrulaResult",false);
        if(__result!=null)
        {
            return QLMHelper.toBoolFromString(((org.w3c.dom.Element)__result).getTextContent());
        }
        return null;
    }
    protected void sendRequest(String soapAction,org.w3c.dom.Document soapBody, QLMRequestResultHandler handler) throws java.lang.Exception
    {
        HashMap< String,String> __headers = new HashMap<>();
        __headers.putAll(httpHeaders);
        __headers.put("SOAPAction",soapAction);
        __headers.put("user-agent","easyWSDL Generator 9.0.1.0");
        __headers.put("content-type","text/xml;charset=UTF-8");
        if (userName != null)
        {
            String authStr = userName+":"+password;
            String data=Base64.getEncoder().encodeToString(authStr.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            String authValue = "Basic "+data;
            __headers.put("authorization",authValue);
        }
        String __requestBody=QLMHelper.getStringFromDocument(soapBody);
        if(enableLogging)
        {
            System.out.println("requestDump: "+__requestBody);
        }
        QLMResponseData response=connectionProvider.sendRequest(url,__requestBody, __headers,handler);
        if(enableLogging)
        {
             System.out.println("responseDump: "+response.getBody());
        }
        handler.setResponse(response);
    }
}
