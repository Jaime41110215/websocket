package com.life.app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wanghongchao
 * @time 2019/4/24
 */
public class ServerSentEvent extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // ContentType 必须指定为 text/event-stream
    resp.setContentType("text/event-stream");
    // CharacterEncoding 必须指定为 UTF-8
    resp.setCharacterEncoding("UTF-8");
    PrintWriter pw = resp.getWriter();
    for(int i=0; i<10; i++) {
      // 每次发送的消息必须以\n\n结束

      pw.write("data: " + "hello" + i + "\n\n");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    pw.close();
  }
}
