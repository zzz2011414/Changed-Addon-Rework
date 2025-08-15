package net.foxyas.changedaddon.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractSyringeItem extends Item {

    public AbstractSyringeItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if(hand != InteractionHand.MAIN_HAND) return InteractionResultHolder.pass(player.getOffhandItem());

        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getMainHandItem());
    }

    //copy from a_changed
    protected ItemStack onUse(@NotNull ItemStack inUse, @NotNull ItemStack result, @NotNull LivingEntity entity){
        if(!(entity instanceof Player player) || !player.isCreative()) {
            if (inUse.getCount() == 1) {
                return result;
            }
            inUse.shrink(1);
            if(result.isEmpty()) return inUse;
        }

        if(entity instanceof Player player) {
            if(!player.isCreative()) ItemHandlerHelper.giveItemToPlayer(player, result);
        } else Block.popResource(entity.level, entity.blockPosition(), result);
        return inUse;
    }
}
