package io.github.apple502j.poifix.mixin;

import java.util.Set;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PointOfInterestTypes.class)
public class PointOfInterestTypesMixin {
	@Shadow
	private static Set<BlockState> POI_STATES;

	@Inject(at = @At("HEAD"), method = "register")
	private static void addStates(Registry<PointOfInterestType> registry, RegistryKey<PointOfInterestType> key, Set<BlockState> states, int ticketCount, int searchDistance, CallbackInfoReturnable<PointOfInterestType> cir) {
		POI_STATES.addAll(states);
	}
}
