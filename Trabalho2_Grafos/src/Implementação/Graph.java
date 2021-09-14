package Implementação;

import java.util.ArrayList;
import java.util.Hashtable;

public class Graph {
	
	private int N;
	private Hashtable<Integer, ArrayList<Integer>> vertex;
		
	public Graph(int N) {
		this.N=N;
		vertex = new Hashtable<>(N+1);
		
		for(int x = 1; x <= N; x++) {
			vertex.put(x, new ArrayList<Integer>());
		}}
	
	
	public void addEdge(Integer source, Integer target) {
		vertex.get(source).add(target);
		vertex.get(target).add(source);
	}
	
// Boolean para as definições de cada grafo	
	public boolean Dirac() {
			for(int x = 1; x <= N; x++) {
			if(vertex.get(x).size() < (((float)N)/2) ) {
				return false;
			}}
		
		return true;
	}
	
	
	public boolean Ore() {
		
		for(int x = 1; x <= N; x++) {
			for(int y = (x+1); y <= N; y++) {
				
				if(!vertex.get(x).contains(y)) {		
					
					if(vertex.get(x).size() + vertex.get(y).size() < N) {
						return false;
					}
				}
			}}
		
		return true;
	}
	
	
	public boolean BC() {	
		
		for(int x = 1; x <= N; x++) {
			for(int y = (x+1); y <= N; y++) {
				
				if( (!vertex.get(x).contains(y)) ) {
					
					if(vertex.get(x).size() + vertex.get(y).size() >= N) {
						this.addEdge(x, y);	
					}
				}
			}}
				
		return Completo();
	}

	
	private boolean Completo() {		
		for(int x = 1; x <= N; x++) {
			if(vertex.get(x).size() != (N-1)) {
				return false;
			}}
		
		return true;
	}
	
	
	public void printGraph() {
		for(int x = 1; x <= N; x++) {
			System.out.println(x + " -> " + vertex.get(x) + "\n");
		}
	}
	
}