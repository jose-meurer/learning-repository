package com.josemeurer.store.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserIpDto {

    private String remoteAddr;
    private Integer remotePort;
    private String remoteHost;

    private String localAddr;
    private Integer localPort;
    private String localName;
    private String serverName;

    private String forwarded;

    private Map<String, String> headers = new HashMap<>();

    public UserIpDto() {
    }

    public UserIpDto(String remoteAddr, Integer remotePort, String remoteHost, String localAddr, Integer localPort, String localName, String serverName, String forwarded) {
        this.remoteAddr = remoteAddr;
        this.remotePort = remotePort;
        this.remoteHost = remoteHost;
        this.localAddr = localAddr;
        this.localPort = localPort;
        this.localName = localName;
        this.serverName = serverName;
        this.forwarded = forwarded;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public Integer getRemotePort() {
        return remotePort;
    }

    public void setRemotePort(Integer remotePort) {
        this.remotePort = remotePort;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public String getLocalAddr() {
        return localAddr;
    }

    public void setLocalAddr(String localAddr) {
        this.localAddr = localAddr;
    }

    public Integer getLocalPort() {
        return localPort;
    }

    public void setLocalPort(Integer localPort) {
        this.localPort = localPort;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getForwarded() {
        return forwarded;
    }

    public void setForwarded(String forwarded) {
        this.forwarded = forwarded;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
