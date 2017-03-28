package ch.heigvd.res.labs.roulette.net.client;

import ch.heigvd.res.labs.roulette.data.EmptyStoreException;
import ch.heigvd.res.labs.roulette.data.JsonObjectMapper;
import ch.heigvd.res.labs.roulette.data.Student;
import ch.heigvd.res.labs.roulette.data.StudentsList;
import ch.heigvd.res.labs.roulette.net.protocol.InfoCommandResponse;
import ch.heigvd.res.labs.roulette.net.protocol.RouletteV1Protocol;
import ch.heigvd.res.labs.roulette.net.protocol.RouletteV2Protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class implements the client side of the protocol specification (version 2).
 *
 * @author Olivier Liechti
 */
public class RouletteV2ClientImpl extends RouletteV1ClientImpl implements IRouletteV2Client {

    @Override
    public void clearDataStore() throws IOException {
        outToServer.println(RouletteV2Protocol.CMD_CLEAR);
        outToServer.flush();
        inFromServer.readLine();
    }

    @Override
    public List<Student> listStudents() throws IOException {
        outToServer.println(RouletteV2Protocol.CMD_LIST);
        outToServer.flush();

        LinkedList<Student> list = new LinkedList<>();
        String st;
        while ((st = inFromServer.readLine()) != null) {
            list.add(JsonObjectMapper.parseJson(st, Student.class));
        }

        return list;
    }

}
