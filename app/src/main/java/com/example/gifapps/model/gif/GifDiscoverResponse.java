package com.example.gifapps.model.gif;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GifDiscoverResponse{

	@SerializedName("next")
	private String next;

	@SerializedName("results")
	private ArrayList<GifDiscoverResultsItem> results;

	public void setNext(String next){
		this.next = next;
	}

	public String getNext(){
		return next;
	}

	public void setResults(List<GifDiscoverResultsItem> results){
		this.results = (ArrayList<GifDiscoverResultsItem>) results;
	}

	public ArrayList<GifDiscoverResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"GifDiscoverResponse{" + 
			"next = '" + next + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}