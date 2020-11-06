import java.util.*;

public class menu {
	Scanner in = new Scanner(System.in);
	int menu;
	HashMap<String, Integer> keyboardmap = new HashMap<>();
	ArrayList<Product> productlist = new ArrayList<>(); 
	Product product = new Product();

	public menu() {
		input();
	}

	public void input() {
		while(true) {
			System.out.println("\n");
			System.out.println("��������������������");
			System.out.println("  menu");
			System.out.println("1. ���콺");
			System.out.println("2. Ű����");
			System.out.println("��������������������");
			System.out.print("��ǰ�Է�>");
			menu = in.nextInt();

			switch (menu) {
			case 1:
				mouse();
				break;
			case 2:
				keyboard();
				break;

			default:
				System.out.println("1,2�� �Է����ּ���");
				break;		
			}



		}
	}


	public void keyboard() {
		exit:
			while(true) {
				System.out.println("\n");
				System.out.println("��������������������������������������");
				keyboardmap.put("����Ű����", 1000);
				keyboardmap.put("���Ű����", 2000);
				keyboardmap.put("�ʷ�Ű����", 3000);

				int index = 1;
				Iterator<String> keys = keyboardmap.keySet().iterator();

				while (keys.hasNext()) {
					String key = keys.next();
					System.out.println(index +"."+ key + ", ���� : " + keyboardmap.get(key));
					index++;
				}
				System.out.println("4.�ڷΰ���");
				System.out.println("��������������������������������������");
				System.out.print("��ǰ���� >");
				int keyboard = in.nextInt();

				switch (keyboard) {
				case 1:
					product("����Ű����");

					break;
				case 2:
					product("���Ű����");

					break;
				case 3:
					product("�ʷ�Ű����");

					break;
				case 4:
					break exit;

				default:
					System.out.println("1~3���� �Է����ּ���");
					break;
				}
			}
	}

	public void product(String Product) {
		System.out.println(Product+ "�� �����ϼ̽��ϴ�");
		System.out.println("\n");
		System.out.println("1.��ٱ��Ͽ� �ֱ�");
		System.out.println("2.�����ϱ�");
		System.out.println("3.����ϱ�");
		System.out.print("�Է� >");

		int menu1 = in.nextInt();
		switch (menu1) {
		case 1:
			System.out.println("��ٱ��Ͽ� �����ϴ�");
			product.setProductname(Product);
			product.setProductprice(keyboardmap.get(Product));
			productlist.add(product);

			gobasket();
			break;
		case 2:
			pay();
			break;
		case 3:
			System.out.println(Product + "�� ����ϼ̽��ϴ�. ����ȭ������ ���ư��ϴ�");
			input();
			break;

		default:
			System.out.println("1~3���� �Է°����մϴ�");
			break;
		}
	}

	public void gobasket() {
		System.out.println("\n");
		System.out.println("1.��ٱ��ϰ���");
		System.out.println("2.�޴�����");
		System.out.print("�Է� >");

		int menu2 = in.nextInt();
		if (menu2 ==1) {
			basket();
		}else if (menu ==2) {
			input();
		}		
	}

	public void basket() {
		int sum =0;
		for (int i = 0; i < productlist.size(); i++) {
			sum += productlist.get(i).getProductprice();
		}
		if (!productlist.isEmpty()) {
			System.out.println(" ");
			System.out.println("�����̸�  |  ����");
			for (int i = 0; i < productlist.size(); i++) {
				System.out.println(productlist.get(i).productname +" |"+ productlist.get(i).productprice);
			}
			System.out.println("��������������������������������������");
			System.out.println("�� ���� :" + sum);
		}if (productlist.isEmpty()) {
			System.out.println("��ٱ��ϰ� �������");
		}


		System.out.println("1.�����ϱ�");
		System.out.println("2.�����ϱ�");
		System.out.print("�Է� >");

		int menu = in.nextInt();

		if (menu ==1) {
			pay();
		}else if (menu ==2) {
			input();
		}
	}

	public void pay() {
		

	}

	public void mouse() {
		System.out.println("soudout");

	}
}
