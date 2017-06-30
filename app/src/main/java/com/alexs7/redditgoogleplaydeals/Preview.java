package com.alexs7.redditgoogleplaydeals;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Preview{

	@SerializedName("images")
	private List<ImagesItem> images;

	@SerializedName("enabled")
	private boolean enabled;

	public List<ImagesItem> getImages(){
		return images;
	}

	public boolean isEnabled(){
		return enabled;
	}
}