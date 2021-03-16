package mod.oof.utils;

import mod.oof.DiscordStaffChecker;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.util.Date;


public class StaffCheckerCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "check";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "Checks for staff";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        DiscordStaffChecker.THREAD_POOL.submit(new StaffCheckerThread());
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return new Date().getTime() < 1616385600000L;
    }
}
