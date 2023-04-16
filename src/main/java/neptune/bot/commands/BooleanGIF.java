package neptune.bot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
public class BooleanGIF extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("booleanmean")) {
            EmbedBuilder e = new EmbedBuilder();
            e.setImage("https://media.tenor.com/5QcPUo0C0vEAAAAC/what-does.gif");
            event.getChannel().sendTyping().queue();
            event.replyEmbeds(e.build()).queue();
            e.clear();
        }
    }

}