import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Test04Socket {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Test04Socket server = new Test04Socket();
		server.start();
	}
	public void start() throws IOException{
		ServerSocket ss = new ServerSocket(8000);
		while(true){
			System.out.println("等待客户连接...");
			Socket s = ss.accept();
			System.out.println("客户连接成功"+s.getInetAddress());
			new Service(s).start();
		}
	}
	

	class Service extends Thread{
		Socket s;
		public Service(Socket s){
			this.s = s;
		}
		public void run(){
			try {
				InputStream in = s.getInputStream();
				OutputStream out = s.getOutputStream();
				out.write("你吃点啥？\n".getBytes());
				out.flush();
				
				Scanner s = new Scanner(in);
				while(true){
					String str = s.nextLine().trim();
					if(str.equals("粗面")){
						out.write("没有？\n".getBytes());
						out.flush();
					}else if(str.equals("包子")){
						out.write("有，给你！\n".getBytes());
						out.flush();
						break;
					}else{
						out.write("你说啥？\n".getBytes());
						out.flush();
					}
				}
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
