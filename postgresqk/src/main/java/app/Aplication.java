
package app;

import java.util.List;
import java.util.Scanner;

import dao.CarroDAO;
import dao.DAO;
import model.Carro;

/**Principal class
 * 
 * @author MateusEvangelistaDoNascimento
 * 
 */
public class Aplication {

	public static void main(String[] args) throws Exception {

		int x;
		Scanner sc = new Scanner(System.in);
		CarroDAO carroDAO = new CarroDAO();
		Carro carro = new Carro(1,"", "", "", 0.0);

		do {
			System.out.println("Digite um numero para as acoes a seguir\n" + "1 - Listar    \n" + "2 - Inserir   \n"
					+ "3 - Excluir   \n" + "4 - Atualizar \n" + "5 - Sair      \n");

			x = sc.nextInt();
			switch (x) {

			case 1:
				List<Carro> carros = carroDAO.getOrderByModelo();
				for (Carro c : carros) {
					System.out.println(c);
				}
				break;

			case 2:
				carro.setId(1);
				carro.setMarca("volkswagen");
				carro.setModelo("virtus");
				carro.setCor("preto");
				carro.setKilometragem(14.32);
				if (carroDAO.insert(carro)) {
					System.out.println("\n\nNovo Carro inserido com sucesso \n" + carro.toString());
				}
				break;

			case 3:
				carroDAO.delete(carro.getId());
				break;

			case 4:
				carro.setCor("branco");
				carroDAO.update(carro); // does not work
				break;

			default:
				System.out.println("Valor Errado");
				break;
			}

		} while (x != 5);

		sc.close();
	}
}
