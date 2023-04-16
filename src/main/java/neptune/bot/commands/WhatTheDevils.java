package neptune.bot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class WhatTheDevils extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("whatthedevils")) {
            EmbedBuilder e = new EmbedBuilder();
            e.setImage("https://media.discordapp.net/attachments/1081690345995247646/1081690359358304396/1664420248149.png?width=398&height=486");
            event.getChannel().sendTyping().queue();
            event.replyEmbeds(e.build()).queue();
            e.clear();

        }
    }

}