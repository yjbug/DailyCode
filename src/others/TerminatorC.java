package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// �����ӵ� �� ��������Ĵӵ�·����
// ����ܴ򵽶�������
// ȷ�����ܵ�����㣬�ֱ������г����ĳ�β
// ������ܵ�������Ӧ�ܻ��Ƶĳ���
// F[i] + F[j] - count    //countΪͬʱ��i,j����ĳ�����
public class TerminatorC {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int Number = scanner.nextInt();
		ArrayList<Integer> shoot = new ArrayList<>();
		ArrayList<int[]> nodes = new ArrayList<>();
		for (int i = 0; i < Number; i++) {
			int[] tmp = new int[2];
			tmp[0] = scanner.nextInt();
			tmp[1] = scanner.nextInt();
			if (!shoot.contains(tmp[0] + tmp[1])) {
				shoot.add(tmp[0] + tmp[1]);
			}
			nodes.add(tmp);
		}
		int size = shoot.size();
		Collections.sort(shoot);
		int F[] = new int[size];
		for (int i = 0; i < F.length; i++) {
			int curShoot = shoot.get(i);
			for (int j = 0; j < Number; j++) {
				int[] temp = nodes.get(j);
				if (temp[0] <= curShoot && curShoot <= temp[0] + temp[1]) {
					F[i]++;
				}
			}
		}
		int curMax = -1;
		int max = -1;
		for (int i = 0; i < F.length; i++) {
			for (int j = i + 1; j < F.length; j++) {
				int cur1 = shoot.get(i);
				int cur2 = shoot.get(j);
				curMax = F[i] + F[j];
				for (int k = 0; k < Number; k++) {
					int[] tmp = nodes.get(k);
					if (tmp[0] <= cur1 && cur2 <= tmp[0] + tmp[1]) {
						curMax--;
					}
				}
				if (max < curMax) {
					max = curMax;
				}
			}
		}
		System.out.println(max);
	}

}