package com.sbt.javaschool.rnd.lesson8serialization.vk;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "album_id",
        "owner_id",
        "user_id",
        "sizes",
        "text",
        "date",
        "lat",
        "long",
        "post_id"
})
public class Item {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("album_id")
    private Integer albumId;
    @JsonProperty("owner_id")
    private Integer ownerId;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("sizes")
    private List<Size> sizes = null;
    @JsonProperty("text")
    private String text;
    @JsonProperty("date")
    private Integer date;
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("long")
    private Double _long;
    @JsonProperty("post_id")
    private Integer postId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("album_id")
    public Integer getAlbumId() {
        return albumId;
    }

    @JsonProperty("album_id")
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    @JsonProperty("owner_id")
    public Integer getOwnerId() {
        return ownerId;
    }

    @JsonProperty("owner_id")
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @JsonProperty("user_id")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty("sizes")
    public List<Size> getSizes() {
        return sizes;
    }

    @JsonProperty("sizes")
    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("date")
    public Integer getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(Integer date) {
        this.date = date;
    }

    @JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @JsonProperty("long")
    public Double getLong() {
        return _long;
    }

    @JsonProperty("long")
    public void setLong(Double _long) {
        this._long = _long;
    }

    @JsonProperty("post_id")
    public Integer getPostId() {
        return postId;
    }

    @JsonProperty("post_id")
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
