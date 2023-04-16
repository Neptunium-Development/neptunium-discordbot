package neptune.bot;

import meteordevelopment.starscript.Script;
import meteordevelopment.starscript.StandardLib;
import meteordevelopment.starscript.Starscript;
import meteordevelopment.starscript.compiler.Compiler;
import meteordevelopment.starscript.compiler.Parser;
import meteordevelopment.starscript.value.Value;
import meteordevelopment.starscript.value.ValueMap;
import org.apache.commons.lang3.time.DurationFormatUtils;

public class NeptuneBotSS {
    public static Starscript RBSS = new Starscript();
    public static String grabstr(String cope){
        Parser.Result r = Parser.parse(cope);
        Script s = Compiler.compile(r);
        return (RBSS.run(s)).toString();
    }
    public static void init(){
        StandardLib.init(RBSS);

        //vals
        RBSS.set("neptunebot", new ValueMap()
                .set("uptime", NeptuneBotSS::uptime)
        );
    }

    private static Value uptime(){
        return Value.string(DurationFormatUtils.formatDuration(System.currentTimeMillis() - Main.starttime, "dd:HH:mm:ss", true));
    }
}
