package chronosacaria.mcdw.mixin;

import chronosacaria.mcdw.bases.McdwBow;
import chronosacaria.mcdw.bases.McdwLongBow;
import chronosacaria.mcdw.bases.McdwShortBow;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(AbstractClientPlayerEntity.class)
public class AbstractClientPlayerEntityMixin {

    @Inject(method = "getFovMultiplier", at = @At(value = "RETURN"), locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
    public void customBowsZoom(CallbackInfoReturnable<Float> cir, float f) {

        AbstractClientPlayerEntity abPlayer = MinecraftClient.getInstance().player;

        if (abPlayer == null)
            return;
        if (abPlayer.getActiveItem() == null)
            return;
        ItemStack itemStack = abPlayer.getActiveItem();
        if (abPlayer.isUsingItem()) {
            if (itemStack.getItem() instanceof McdwBow ||
                    itemStack.getItem() instanceof McdwShortBow ||
                    itemStack.getItem() instanceof McdwLongBow) {
                int i = abPlayer.getItemUseTime();
                float g = (float)i / 20.0F;
                if (g > 1.0F) {
                    g = 1.0F;
                } else {
                    g *= g;
                }

                f *= 1.0F - g * 0.15F;

                cir.setReturnValue(MathHelper.lerp(MinecraftClient.getInstance().options.fovEffectScale, 1.0F, f));
            }
        }
    }
}
