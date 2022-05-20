package me.dreamvoid.hypixelapi;

import net.hypixel.api.HypixelAPI;
import net.hypixel.api.apache.ApacheHttpClient;
import net.hypixel.api.http.HypixelHttpClient;

import java.util.UUID;

public class Hypixel {

	public Hypixel(String APIKey){
		HypixelHttpClient client = new ApacheHttpClient(UUID.fromString("APIKey"));
		HypixelAPI hypixelAPI = new HypixelAPI(client);

		hypixelAPI.getPlayerByName("Hypixel")
				.exceptionally(throwable -> {
					// Handle exceptions here
					throwable.printStackTrace();
					return null;
				})
				.thenAccept(System.out::println);
	}
}
