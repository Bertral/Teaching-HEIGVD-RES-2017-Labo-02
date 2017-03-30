package ch.heigvd.res.labs.roulette.net.client;

import ch.heigvd.res.labs.roulette.data.JsonObjectMapper;
import ch.heigvd.res.labs.roulette.data.Student;
import ch.heigvd.res.labs.roulette.data.StudentsList;
import ch.heigvd.res.labs.roulette.net.protocol.LoadCommandResponse;
import ch.heigvd.res.labs.roulette.net.protocol.RouletteV1Protocol;
import ch.heigvd.res.labs.roulette.net.protocol.RouletteV2Protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

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
        return JsonObjectMapper.parseJson(inFromServer.readLine(), StudentsList.class).getStudents();
    }

    @Override
    public LoadCommandResponse loadStudent(String fullname) throws IOException {
        outToServer.println(RouletteV2Protocol.CMD_LOAD);
        outToServer.println(fullname);
        outToServer.println(RouletteV2Protocol.CMD_LOAD_ENDOFDATA_MARKER);
        outToServer.flush();

        inFromServer.readLine(); //"Send your data"
        LoadCommandResponse lcr = JsonObjectMapper.parseJson(inFromServer.readLine(), LoadCommandResponse.class);

        return lcr;
    }

    @Override
    public LoadCommandResponse loadStudents(List<Student> students) throws IOException {
        outToServer.println(RouletteV1Protocol.CMD_LOAD);
        for (Student s : students) {
            outToServer.println(s.getFullname());
        }
        outToServer.println(RouletteV1Protocol.CMD_LOAD_ENDOFDATA_MARKER);
        outToServer.flush();
        inFromServer.readLine(); //"Send your data"

        LoadCommandResponse lcr = JsonObjectMapper.parseJson(inFromServer.readLine(), LoadCommandResponse.class);
        return lcr;
    }
}
