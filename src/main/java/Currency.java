import com.google.gson.annotations.SerializedName;

public record Currency(
        @SerializedName("") String name,
        @SerializedName("") String isoCode,
        @SerializedName("") String country)
{}