package dev.vatuu.liltater.block;

import com.google.common.collect.ImmutableList;
import dev.vatuu.liltater.util.Registrable;

import java.util.List;

public final class Blocks {

    private static final List<Registrable> blocks = ImmutableList.of(
            new LilTaterBlock(),
            new IrritaterBlock()
    );

    public static void init() {
        blocks.forEach(Registrable::register);
    }
}
