package kimsmileGames.service;

import kimsmileGames.model.Member;

import java.io.IOException;

public interface MemberService {

    void login();

    void join() throws IOException, InterruptedException;
}
