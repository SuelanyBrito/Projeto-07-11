package sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

import post.Hashtag;
import usuario.Usuario;

public class TrendingTopics {
	
	List<Hashtag> hashtags;
	

	public TrendingTopics() {
		this.hashtags = new ArrayList<Hashtag>();
		
		
	}
	
	
	public void adicionaHashTags(Hashtag hashtag){
		this.hashtags.add(hashtag);
	}
	
	
	

}
