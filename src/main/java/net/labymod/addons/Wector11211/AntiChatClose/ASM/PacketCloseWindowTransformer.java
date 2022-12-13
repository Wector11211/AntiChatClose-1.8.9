package net.labymod.addons.Wector11211.AntiChatClose.ASM;

import net.labymod.core.asm.global.ClassEditor;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

public class PacketCloseWindowTransformer implements IClassTransformer {

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
            if ("gb".equals(name) || "net.minecraft.network.play.server.S2EPacketCloseWindow".equals(name)) {
                System.out.println("[AntiChatClose] Transforming S2EPacketCloseWindow class");
                ClassNode node = new ClassNode();
                ClassEditor editor = new ProcessPacketEditor();
                ClassReader reader = new ClassReader(basicClass);
                reader.accept(node, 0);
                editor.accept(name, node);
                ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
                node.accept(writer);
                return writer.toByteArray();
            }
        return basicClass;
    }
}
