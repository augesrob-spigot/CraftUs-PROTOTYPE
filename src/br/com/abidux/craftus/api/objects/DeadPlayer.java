package br.com.abidux.craftus.api.objects;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.util.EulerAngle;

import br.com.abidux.craftus.api.PlayerType;
import br.com.abidux.craftus.utils.HologramBuilder;

public class DeadPlayer {
	
	private ArrayList<ArmorStand> stands;
	private ArmorStand body;
	
	public DeadPlayer build(CraftUsProfile profile) {
		profile.setType(PlayerType.DEAD_CREWMATE);
		profile.getPlayer().setGameMode(GameMode.SPECTATOR);
		ArmorStand as = (ArmorStand) profile.getPlayer().getWorld().spawnEntity(profile.getPlayer().getLocation(), EntityType.ARMOR_STAND);
		Location loc = as.getLocation().clone();
		loc.setYaw(loc.getYaw()+192);
		as.setBasePlate(false);
		as.setArms(true);
		as.setBodyPose(new EulerAngle(0, 91, 0));
		as.setHeadPose(new EulerAngle(91, 0, 186));
		as.setLeftArmPose(new EulerAngle(91, 0, 0));
		as.setRightArmPose(new EulerAngle(91, 4, 0));
		as.setHelmet(profile.getColor().getHead());
		as.setChestplate(profile.getColor().getChestplate());
		as.setLeggings(profile.getColor().getLeggings());
		as.setBoots(profile.getColor().getBoots());
		ArrayList<ArmorStand> stands = new HologramBuilder(profile.getPlayer().getLocation().add(0, 1, 0)).lines("�cX").build();
		this.stands = stands;
		this.body = as;
		return this;
	}
	
	public ArmorStand getBody() {
		return body;
	}
	
	public ArrayList<ArmorStand> getStands() {
		return stands;
	}
	
}