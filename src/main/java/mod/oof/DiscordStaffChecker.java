package mod.oof;

import mod.oof.utils.StaffCheckerCommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@Mod(modid = DiscordStaffChecker.MOD_ID)
public class DiscordStaffChecker {
    public static final String MOD_ID = "oofdiscord";
    public static final ExecutorService THREAD_POOL = Executors.newCachedThreadPool(new ThreadFactory() {
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "oofdiscord" + this.threadNumber.getAndIncrement());
        }
    });

    private static DiscordStaffChecker instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        instance = this;

        ClientCommandHandler.instance.registerCommand(new StaffCheckerCommand());
    }

    public static DiscordStaffChecker getInstance() {
        return instance;
    }
}
