package neptune.bot;

import neptune.bot.commands.BooleanGIF;
import neptune.bot.commands.WhatTheDevils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import java.util.*;

public class Main extends ListenerAdapter {
    public static JDA JDA;
    public static long starttime;
    public static String token = "";
    private static List<String> copiumwords = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Starting");
        starttime = System.currentTimeMillis();
        NeptuneBotSS.init();
        copiumwords.add("virus");
        copiumwords.add("rat");
        copiumwords.add("trojan");
        copiumwords.add("spyware");
        copiumwords.add("adware");
        copiumwords.add("malicious");
        copiumwords.add("malware");
        copiumwords.add("hijacking");
        copiumwords.add("ransomware");
        copiumwords.add("worm");
        copiumwords.add("miner");
        copiumwords.add("rootkit");
        JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.MESSAGE_CONTENT)
                .enableCache(CacheFlag.EMOJI)
                .addEventListeners(new Main(), new WhatTheDevils(), new BooleanGIF())
                .build();
    }

    @Override
    public void onReady(ReadyEvent event){
        JDA = event.getJDA();
        JDA.getPresence().setActivity(Activity.playing("NeptuniumClient"));
        System.out.println("Loaded!");
        JDA.upsertCommand("whatthedevils", "wtd gif");
        JDA.upsertCommand("booleanmeme", "what does a boolean mean");
        JDA.updateCommands();
    }

    public static void HASHMAP(MessageReceivedEvent event){
        event.getChannel().sendMessage("HASHMAP").queue();
        event.getChannel().sendMessage("i would use a hashmap").queue();
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        if ((msg.toLowerCase().contains("what would you do")))HASHMAP(event);
        if (msg.toLowerCase().contains("what would you use")) HASHMAP(event);
        if (msg.toLowerCase().contains("seedcracker")) seedcrackers(event);
        if (msg.contains("!uptime")) event.getChannel().sendMessage(NeptuneBotSS.grabstr("{neptunebot.uptime}")).queue();
        if (msg.toLowerCase().contains("i don't like pegasus")) event.getMessage().delete().queue();

        for (String buh : copiumwords){
            if (msg.toLowerCase().contains(buh)) event.getMessage().reply("This is not a security risk, you can check the src yourself retard").queue();
        }
    }

    public static void seedcrackers(MessageReceivedEvent event) {
        EmbedBuilder e = new EmbedBuilder();
        e.setImage("https://media.discordapp.net/attachments/1081690345995247646/1081986210966290573/893615002015-1-316249021.jpg?width=486&height=486");
        event.getChannel().sendMessageEmbeds(e.build()).queue();
        e.clear();
    }


    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("booleanmean", "what does a boolean mean"));
        commandData.add(Commands.slash("whatthedevils", "wtd gif"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }


}
