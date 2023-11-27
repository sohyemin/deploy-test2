package dockerstudy.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TestApplicationTests {

	@Test
	void contextLoads() {

	}

	static int y = 0,x = 0, width = 0, height = 0;
	@Test
	void test() {
		String[] park = {"SOOXO", "OOOXO", "OXOOO", "XOOOO"};
		String[] routes = {"E 2", "S 2", "W 2", "S 1", "W 1"};

		width = park[0].length();
		height = park.length;

		String[][] map = new String[height][width];

		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				map[i][j] = park[i].split("")[j];
				System.out.print(map[i][j]);
				if(map[i][j].equals("S")){
					y = i;
					x = j;
				}
			}
			System.out.println("");
		}

		for(String route : routes){
			String d = route.split(" ")[0];
			int l = Integer.parseInt(route.split(" ")[1]);

			//북쪽으로 이동할 경우
			if(d.equals("N")){
				move("Vertical", -1, l, map);
			}
			//남쪽으로 이동할 경우
			if(d.equals("S"))
				move("Vertical", 1, l, map);

			//서쪽으로 이동할 경우
			if(d.equals("W"))
				move("Horizontal", -1, l, map);

			//동쪽으로 이동할 경우
			if(d.equals("E"))
				move("Horizontal", 1, l, map);

		}

		System.out.println("answer = " + y +", " +x);
	}

	private static void move(String direction, int force, int l, String[][] map) {
		//만약 좌우로 움직인다면 해당 명령어 실행
		if(direction.equals("Horizontal")){
			//진행해서 공원 밖으로 이탈하는지 확인
			if(x+(l*force)>=0 && x+(l*force)< width){
				//진행하는 동안 x를 만나는지 확인
				for (int now = 0; now<l ; now++){
					if(map[y][now*force+x].equals("X")) {
						System.out.println("X");
						return;
					};
				}
			} else return;

			//위 조건을 모두 통과했다면 해당 명령어 실행
			x+=l*force;
		}
		//만약 상하로 움직인다면 해당 명령어 실행
		else if(direction.equals("Vertical")){
			//진행해서 공원 밖으로 이탈하는지 확인
			if(y+(l*force)>=0 && y+(l*force) < height){
				//진행하는 동안 X를 만나는지 확인
				for (int now = 0; now<l ; now++){
					if(map[now*force +y][x].equals("X")) {
						System.out.println("X");
						return;
					};
				}
			} else return;

			//위 조건을 모두 통과했다면 해당 명령어 실행
			y+=l*force;
		}
	}

	@Test
	void test2() {
//		String[] wallpaper = {".#...", "..#..", "...#."};
		String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};

		int luy=-1,lux=-1,rdy=-1,rdx=-1;

		for (int i = 0; i < wallpaper.length; i++) {
			for (int j = 0; j < wallpaper[0].length(); j++) {
				if(wallpaper[i].charAt(j) == '#'){
					if (lux==-1) lux=i;
					rdx=i+1;
				}
			}
		}

		for (int i = 0; i < wallpaper[0].length(); i++) {
			for (int j = 0; j < wallpaper.length; j++) {
				if(wallpaper[j].charAt(i) == '#'){
					if (luy==-1) luy=i;
					rdy=i+1;
				}
			}
		}

		System.out.println(luy+", "+lux+", "+rdy+", "+rdx);

	}

}
