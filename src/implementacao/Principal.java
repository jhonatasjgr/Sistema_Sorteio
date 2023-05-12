package implementacao;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;


import utils.Pessoa;
import utils.Rifa;


public class Principal {
	static int nRifa=1;
	public static void main(String[] args) {
		int op=1;
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		ArrayList<Rifa> rifas = new ArrayList<>();
		Pessoa pessoa ;
		Rifa rifa;
		Random gerador = new Random();
		
		
		
		do{
			op=Integer.parseInt(JOptionPane.showInputDialog(""
					+ "1-CADASTRAR CLIENTE\n"
					+ "2-LISTAR CLIENTE\n"
					+ "3-ALTERAR DADOS CLIENTE\n"
					+ "4-EXCLUIR CLIENTE\n"
					+ ".............................\n"
					+ "5-CADASTRAR RIFA\n"
					+ "6-LISTRAR RIFAS\n"
					+ "7-ALTERAR DADOS RIFA\n"
					+ "8-EXCLUIR RIFA\n"
					+ ".............................\n"
					+ "10-SORTEAR\n"
					+ ".............................\n"
					+ "0-FINALIZAR"));
			switch(op) {
			case 1:
				String nome, cpf, telefone;
				boolean pCpf = false, pTelefone = false, teste=false;
				if(pessoas.size()<1) {
					nome = JOptionPane.showInputDialog("NOME DO CLIENTE");
					cpf = JOptionPane.showInputDialog("CPF DO CLIENTE");
					telefone = JOptionPane.showInputDialog("TELEFONE DO CLIENTE");
					pessoa = new Pessoa(nome, cpf, telefone);
					pessoas.add(pessoa);
					JOptionPane.showMessageDialog(null, "CLIENTE " +nome+ " ADICIONADO COM SUCESSO");
				}else {
					nome = JOptionPane.showInputDialog("NOME DO CLIENTE");
					cpf = JOptionPane.showInputDialog("CPF DO CLIENTE");
					for(Pessoa p: pessoas) {
						teste = (Integer.parseInt(cpf)==Integer.parseInt(p.getCpf()))? true:false;
						if(teste==true) {
							pCpf=true;
						}
					}
					if(pCpf==true) {
						JOptionPane.showMessageDialog(null, "CPF JÁ PERTENCE A OUTRO USUARIO");
					}else {
						teste=false;
						telefone = JOptionPane.showInputDialog("TELEFONE DO CLIENTE");
						for(Pessoa p: pessoas) {
							teste = (Integer.parseInt(telefone)==Integer.parseInt(p.getTelefone()))? true:false;
							if(teste==true) {
								pTelefone=true;
							}
						}
						if(pTelefone==true) {
							JOptionPane.showMessageDialog(null, "TELEFONE JÁ PERTENCENTE A OUTRO USUARIO");
						}else {
							pessoa = new Pessoa(nome,cpf,telefone);
							pessoas.add(pessoa);
							JOptionPane.showMessageDialog(null,"CLIENTE " +nome+ " ADICIONADO COM SUCESSO");					}
					}
				}
				break;
			case 2:
				if(pessoas.size()<1) {
					JOptionPane.showMessageDialog(null, "NENHUM CLIENTE CADASTRADO");
				}else {
					String dados = "";
					for(Pessoa p: pessoas) {
						dados += "NOME: " + p.getNome() + "\nCPF: " + p.getCpf() +
						"\nTELEFONE: " + p.getTelefone() + "\n.............................\n";
					}
					JOptionPane.showMessageDialog(null, dados);
				}
				break;
			case 3:
				int op2 = Integer.parseInt(JOptionPane.showInputDialog("1-ALTERAR CPF\n2-ALTERAR NOME\n3-ALTERAR TELEFONE\n0-VOLTAR MENU PRINCIPAL"));
				switch(op2) {
				case 1:
					cpf = JOptionPane.showInputDialog("DIGITE O CPF DO CLIENTE EM QUE\nDESEJA ALTERAR OS DADOS");
					for(Pessoa p: pessoas) {
						if(Integer.parseInt(cpf)==Integer.parseInt(p.getCpf())) {
							p.setCpf(JOptionPane.showInputDialog("DIGITE O NOVO CPF DO CLIENTE"+p.getNome()));
							JOptionPane.showMessageDialog(null, "CPF ALTERADO COM SUCESSO");
						}
					}
					break;
				case 2:
					cpf = JOptionPane.showInputDialog("DIGITE O CPF DO CLIENTE EM QUE\nDESEJA ALTERAR OS DADOS");
					for(Pessoa p: pessoas) {
						if(Integer.parseInt(cpf)==Integer.parseInt(p.getCpf())) {
							p.setNome(JOptionPane.showInputDialog("DIGITE O NOVO NOME DO CLIENTE"+p.getNome()));
							JOptionPane.showMessageDialog(null, "NOME ALTERADO COM SUCESSO");
						}
					}
					break;
				case 3:
					cpf = JOptionPane.showInputDialog("DIGITE O CPF DO CLIENTE EM QUE\nDESEJA ALTERAR OS DADOS");
					for(Pessoa p: pessoas) {
						if(Integer.parseInt(cpf)==Integer.parseInt(p.getCpf())) {
							p.setTelefone(JOptionPane.showInputDialog("DIGITE O NOVO TELEFONE DO CLIENTE"+p.getNome()));
							JOptionPane.showMessageDialog(null, "TELEFONE ALTERADO COM SUCESSO");
						}
					}
					break;
				case 0:
					break;
				default:
					JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA");
					break;
				}
				break;
			case 4:
				int posi=0;
				boolean existe = false;
				String pose = JOptionPane.showInputDialog("DIGITE O CPF DO CLIENTE QUE DESEJA EXCLUIR");
				for(Rifa r: rifas) {
					for(Pessoa p: pessoas) {
						if(r.getComprador()==p) {
							existe=true;
						}
					}
				}
				for(Pessoa p: pessoas) {
					if(Integer.parseInt(p.getCpf())==Integer.parseInt(pose)) {
						pose=Integer.toString(posi);
					}
				posi++;
				}
				if(existe==true) {
					JOptionPane.showMessageDialog(null,"NÃO É POSSIVEL EXCLUIR ESSE CLIENTE\nPOIS O CLIENTE POSSUI RIFA EM SEU NOME");
				}else {
				 try {
					 pessoas.remove(Integer.parseInt(pose));
					 JOptionPane.showMessageDialog(null,"CLIENTE EXCLUIDO COM SUCESSO");
				    } catch (IndexOutOfBoundsException e) {
				    	 JOptionPane.showMessageDialog(null,"CLIENTE INEXISTENTE", "ERRO", JOptionPane.ERROR_MESSAGE);
				    }
				}
				break;
			case 5:
				String cls = "";
				int i=0;
				for(Pessoa p: pessoas) {
					cls+=p.getCpf()+"-"+p.getNome()+" || ";
					if(i==4) {
						cls+="\n";
						i=0;
					}
					i++;
				}
				Pessoa pp = null;
				cpf = JOptionPane.showInputDialog(cls+"\nESCOLHA O CLIENTE COMPRADOR DIGITANDO O CPF");
				for(Pessoa p: pessoas) {
					if(Integer.parseInt(cpf)==Integer.parseInt(p.getCpf())) {
						pp = p;
					}
				}
				rifa = new Rifa(nRifa, pp);
				rifas.add(rifa);
				JOptionPane.showMessageDialog(null, "PONTO CADASTRADO\nCOMPRADOR: "+pp.getNome()+"\nNUMERO DO PONTO: "+nRifa);
				nRifa++;
				break;
			case 6:
				 cls = "";
				for(Rifa r: rifas) {
					cls+="COMPRADOR: "+r.getComprador().getNome()+"\nCPF: "+r.getComprador().getCpf()
					+"\nNUMERO DA RIFA: "+r.getId()+
					"\n.........................................\n";
				}
				JOptionPane.showMessageDialog(null, cls);
				break;
			case 7:
				pp=null;
				String num = JOptionPane.showInputDialog("DIGITE O NUMERO DO PONTO QUE DESEJA ALTERAR O COMPRADOR");
				for(Rifa r: rifas) {
					if(Integer.parseInt(num)==r.getId()) {
						String p= JOptionPane.showInputDialog("\nDIGITE O CPF DO NOVO COMPRADOR");
						for(Pessoa x: pessoas) {
							if(Integer.parseInt(p)==Integer.parseInt(x.getCpf())) {
								pp=x;
							}
						}
						r.setComprador(pp);
						JOptionPane.showMessageDialog(null, "NOVO COMPRADOR: "+pp.getNome());
					}
				}
				break;
			case 8:
				 posi=0;
				 pose = JOptionPane.showInputDialog(null, "DIGITE O NUMERO DO PONTO QUE DESEJA EXCLUIR");
				for(Rifa r: rifas) {
					if(r.getId()==Integer.parseInt(pose)) {
						pose=Integer.toString(posi);
					}
				posi++;
				}
				 try {
					 rifas.remove(Integer.parseInt(pose));
					 JOptionPane.showMessageDialog(null,"PONTO ESCLUIDO COM SUCESSO");
				    } catch (IndexOutOfBoundsException e) {
				    	 JOptionPane.showMessageDialog(null,"PONTO INEXISTENTE", "ERRO", JOptionPane.ERROR_MESSAGE);
				    }
				break;
			case 10:
				existe=false;
				Rifa rf = null;
				int tamanho = rifas.size()+1;
				int nSorteado = gerador.nextInt(tamanho);
				if(nSorteado==0) {
					nSorteado++;
				}
				if(rifas.size()>0) {
					for(Rifa r: rifas) {
						if(nSorteado==r.getId()) {
							existe=true;
							rf=r;
						}
					}
				JOptionPane.showMessageDialog(null,"RIFA "+nSorteado+" SORTEADA\nPARABENS AO VENCEDOR-> "+rf.getComprador().getNome());
				}else {
					JOptionPane.showMessageDialog(null, "NÃO É POSSIVEL SORTEAR SEM ALGUM PONTO DE RIFA CADASTRADO");
				}
				break;
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA\nTENTE NOVAMENTE");
				break;
			}
			
		}while(op!=0);
	}

}
