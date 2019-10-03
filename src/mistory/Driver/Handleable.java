package mistory.Driver;

import mistory.interfaces.Packet;

public interface Handleable {
    void execute(Packet packet);
}
