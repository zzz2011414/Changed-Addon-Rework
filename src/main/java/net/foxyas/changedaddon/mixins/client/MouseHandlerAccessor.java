package net.foxyas.changedaddon.mixins.client;

import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MouseHandler.class)
public interface MouseHandlerAccessor {
    @Accessor("xpos")
    void setXpos(double value);

    @Accessor("ypos")
    void setYpos(double value);

    //@Invoker("onMove")
    //void onMove(long pWindowPointer, double Xpos, double Ypos);
}

