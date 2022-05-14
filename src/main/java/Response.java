import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    @JsonProperty("copyright")
    private String copyright;
    @JsonProperty("date")
    private String date;
    @JsonProperty("explanation")
    private String explanation;
    @JsonProperty("hdurl")
    private String hdurl;
    @JsonProperty("media_type")
    private String mediaType;

    @JsonProperty("service_version")
    private String serviceVersion;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;

    public Response(String copyright,
                    String date,
                    String explanation,
                    String hdurl,
                    String mediaType,
                    String serviceVersion,
                    String title,
                    String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public Response setCopyright(String copyright) {
        this.copyright = copyright;
        return this;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public Response setDate(String date) {
        this.date = date;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public Response setExplanation(String explanation) {
        this.explanation = explanation;
        return this;
    }

    public Response setTitle(String title) {
        this.title = title;
        return this;
    }

    public Response setUrl(String url) {
        this.url = url;
        return this;
    }

    public Response setHdurl(String hdurl) {
        this.hdurl = hdurl;
        return this;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    @Override
    public String toString() {
        return "<" + copyright + ", " + date + ", " + explanation + ", " + hdurl + ", " + mediaType + ", " + serviceVersion + ", " + title + ", " + url + ".>";
    }
}
