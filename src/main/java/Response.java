import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    private String mediaType;

    private String serviceVersion;
    private String title;
    private String url;

    public Response(@JsonProperty("copyright") String copyright,
                    @JsonProperty("date") String date,
                    @JsonProperty("explanation") String explanation,
                    @JsonProperty("hdurl") String hdurl,
                    @JsonProperty("media_type") String mediaType,
                    @JsonProperty("service_version") String serviceVersion,
                    @JsonProperty("title") String title,
                    @JsonProperty("url") String url) {
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
