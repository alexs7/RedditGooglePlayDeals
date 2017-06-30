package com.alexs7.redditgoogleplaydeals;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ImagesItem{

	@SerializedName("resolutions")
	private List<ResolutionsItem> resolutions;

	@SerializedName("source")
	private Source source;

	@SerializedName("variants")
	private Variants variants;

	@SerializedName("id")
	private String id;

	public List<ResolutionsItem> getResolutions(){
		return resolutions;
	}

	public Source getSource(){
		return source;
	}

	public Variants getVariants(){
		return variants;
	}

	public String getId(){
		return id;
	}
}