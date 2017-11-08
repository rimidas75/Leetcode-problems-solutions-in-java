

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MST_Rimi_Das_rimidas {

	List<Integer> weightList = new ArrayList<Integer>();
	List<Integer> parentVertex = new ArrayList<Integer>();
	static Map<Integer, List<AdjNode>> graph = new HashMap<Integer, List<AdjNode>>();
	List<List<Integer>> final_list_of_edges = new ArrayList<List<Integer>>();
	List<Boolean> vertices = new ArrayList<Boolean>();
	MinHeap minHeap = new MinHeap();
	int n, m = 0, current;
	List<AdjNode> list;
	int sum = 0;
	private static BufferedWriter bw;
	static File outputFile = null;

	public List<Integer> getWeightList() {
		return weightList;
	}

	public List<Integer> getParentVertex() {
		return parentVertex;
	}

	public void FileWriter() {

		outputFile = new File("output.txt");
		if (!outputFile.exists()) {
			try {
				outputFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {

			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeToFile(BufferedWriter bw2, String string) {
		try {
			bw.write(string);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Map<Integer, List<AdjNode>> fileReader(String filePath) {

		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));

			String sCurrentLine;
			String[] splitTerms;
			int line_num = 0;

			while ((sCurrentLine = br.readLine()) != null) {
				String lineText = sCurrentLine;
				line_num++;
				List<Integer> splitNum = new ArrayList<Integer>();
				splitTerms = lineText.split(" ");
				for (String s : splitTerms) {
					splitNum.add(Integer.parseInt(s));
				}
				if (line_num == 1) {
					n = splitNum.get(0);
					m = splitNum.get(1);
				} else {
					//Creating the adjacency list for every vertex
					if (null != graph.get(splitNum.get(0))) {
						list = new ArrayList<AdjNode>();
						AdjNode adjNode = new AdjNode();
						adjNode.setNodeVal(splitNum.get(1));
						adjNode.setWeight(splitNum.get(2));
						list = graph.get(splitNum.get(0));
						list.add(adjNode);
						graph.put(splitNum.get(0), list);

					}
					if (null != graph.get(splitNum.get(1))) {
						// for undirected graph,adjacency is both-ways
						list = new ArrayList<AdjNode>();
						AdjNode adjNode1 = new AdjNode();
						adjNode1.setNodeVal(splitNum.get(0));
						adjNode1.setWeight(splitNum.get(2));
						list = graph.get(splitNum.get(1));
						list.add(adjNode1);
						graph.put(splitNum.get(1), list);

					}

					if (null == graph.get(splitNum.get(0))) {
						list = new ArrayList<AdjNode>();
						AdjNode adjNode = new AdjNode();
						adjNode.setNodeVal(splitNum.get(1));
						adjNode.setWeight(splitNum.get(2));
						list.add(adjNode);
						graph.put(splitNum.get(0), list);
					}
					if (null == graph.get(splitNum.get(1))) {
						list = new ArrayList<AdjNode>();
						AdjNode adjNode = new AdjNode();
						adjNode.setNodeVal(splitNum.get(0));
						adjNode.setWeight(splitNum.get(2));
						list.add(adjNode);
						graph.put(splitNum.get(1), list);
					}

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return graph;
	}

	public void Prim_MST_initialize() {
		
		for (int i = 0; i <= n; i++) {
			weightList.add(i, Constants.INFINITY); // Initial weight to every vertex
			parentVertex.add(i, 0);//to track the parent vertex of a neighbor vertex in MST
			vertices.add(i, Boolean.FALSE); //to maintain the visited vertices
		}
		weightList.set(1, 0);
		parentVertex.set(1, -1);
		minHeap.add(weightList.get(1), 1);
	}

	public void Prim() {
		int c = 0, u = 0, w = 0;
		while (!minHeap.empty()) {
			c++;
			current = minHeap.extractMinNode();

			if (c > 1) {

				List<Integer> edge = new ArrayList<Integer>();
				int min = parentVertex.get(current);
				int max = current;
				/*
				 * int temp = 0; if(min>max) { temp = min; min = max; max =
				 * temp; }
				 */
				edge.add(0, min);
				edge.add(1, max);
				sum = sum + weightList.get(current);
				final_list_of_edges.add(edge);

			}

			// System.out.println("Current == "+current);

			vertices.set(current, true);
			// find neighbours
			List<AdjNode> adjList = graph.get(current);
			for (AdjNode ad : adjList) {
				u = ad.getNodeVal();
				w = ad.getWeight();

				if (!vertices.get(u) && !minHeap.containsData(u)) {
					if (null != weightList.get(u) && w < weightList.get(u)) {

						minHeap.add(w, u);
						updateWeightParent(current, u, w);

					}

				} else if (!vertices.get(u) && minHeap.containsData(u)) {
					if (null != weightList.get(u) && w < weightList.get(u)) {
						minHeap.decrease(u, w);
						updateWeightParent(current, u, w);

					}

				}

			}

		}

		displayPrimMST();
	}

	protected void updateWeightParent(int current, int u, int w) {
		weightList.set(u, w);
		parentVertex.set(u, current);

	}

	private void displayPrimMST() {

		writeToFile(bw, sum + "\n");
		for (List<Integer> e : final_list_of_edges) {
			writeToFile(bw, e.get(0) + " " + e.get(1) + "\n");
			// System.out.println(e.get(0)+ ","+ e.get(1));

		}
		try {
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {

		MST_Rimi_Das_rimidas prim = new MST_Rimi_Das_rimidas();

		prim.fileReader("input.txt");
		prim.FileWriter();
		prim.Prim_MST_initialize();
		prim.Prim();

	}
	
	public class MinHeap {

		protected List<Node> nodeList = new ArrayList<>();
		protected Map<Integer, Integer> nodePosition = new HashMap<>();

		public class Node {
			int weight;
			int key;
		}

		/**
		 * Checks where the key exists in heap or not
		 */
		public boolean containsData(int key) {
			return nodePosition.containsKey(key);
		}

		/**
		 * Insert new node into the heap
		 */
		public void add(int weight, int key) {
			Node node = new Node();
			node.weight = weight;
			node.key = key;
			nodeList.add(node);
			int size = nodeList.size();
			int current = size - 1;
			int parentIndex = (current - 1) / 2;
			nodePosition.put(node.key, current);

			/**
			 * Heapify_up action on the heap
			 */
			while (parentIndex >= 0) {
				Node parentNode = nodeList.get(parentIndex);
				Node currentNode = nodeList.get(current);
				if (parentNode.weight > currentNode.weight) {
					swap(parentNode, currentNode);
					// updateWeightParent(key,u,weight);
					updatePositionMap(parentNode.key, currentNode.key, parentIndex, current);
					// updateWeightList(currentNode.key,currentNode.weight,parentNode.key);
					current = parentIndex;
					parentIndex = (parentIndex - 1) / 2;
				} else {
					break;
				}
			}
		}

		protected void updatePositionMap(int key1, int key2, int pos1, int pos2) {
			nodePosition.remove(key1);
			nodePosition.remove(key2);
			nodePosition.put(key1, pos1);
			nodePosition.put(key2, pos2);
		}

		/**
		 * To check if heap is empty or not
		 */
		public boolean empty() {
			return nodeList.size() == 0;
		}

		/**
		 * Decreases the weight of given key to a new Weight
		 */
		public void decrease(int data, int newWeight) {
			Integer position = nodePosition.get(data);
			nodeList.get(position).weight = newWeight;
			int parent = (position - 1) / 2;
			while (parent >= 0) {
				if (nodeList.get(parent).weight > nodeList.get(position).weight) {
					swap(nodeList.get(parent), nodeList.get(position));
					updatePositionMap(nodeList.get(parent).key, nodeList.get(position).key, parent, position);
					position = parent;
					parent = (parent - 1) / 2;
				} else {
					break;
				}
			}
		}

		/**
		 * Returns the minimum node of the heap
		 */
		public int extractMinNode() {
			int size = nodeList.size() - 1;
			Node minNode = new Node();
			minNode.key = nodeList.get(0).key;
			minNode.weight = nodeList.get(0).weight;

			int lastNodeWeight = nodeList.get(size).weight;
			nodeList.get(0).weight = lastNodeWeight;
			nodeList.get(0).key = nodeList.get(size).key;
			nodePosition.remove(minNode.key);
			nodePosition.remove(nodeList.get(0));
			nodePosition.put(nodeList.get(0).key, 0);
			nodeList.remove(size);

			/**
			 * Heapify_down action on heap
			 */
			int currentIndex = 0;
			size--;
			int min = 0;
			while (true) {
				int leftChild = 2 * currentIndex + 1;
				int rightChild = 2 * currentIndex + 2;
				if (leftChild > size) {
					break;
				}
				if (rightChild > size) {
					rightChild = leftChild;
				}
				if (nodeList.get(leftChild).weight <= nodeList.get(rightChild).weight)
					min = leftChild;
				else
					min = rightChild;

				if (nodeList.get(currentIndex).weight > nodeList.get(min).weight) {
					swap(nodeList.get(currentIndex), nodeList.get(min));
					// updateWeightParent(current,u,w);
					updatePositionMap(nodeList.get(currentIndex).key, nodeList.get(min).key, currentIndex, min);
					currentIndex = min;
				} else {
					break;
				}
			}
			return minNode.key;
		}

		private void swap(Node node1, Node node2) {
			int weight = node1.weight;
			int data = node1.key;

			node1.key = node2.key;
			node1.weight = node2.weight;

			node2.key = data;
			node2.weight = weight;
		}

	}
	public final class Constants {
		public static final int INFINITY = 100001;

	}
	public class AdjNode {
		int nodeVal;
		int weight;
		public int getNodeVal() {
			return nodeVal;
		}
		public void setNodeVal(int nodeVal) {
			this.nodeVal = nodeVal;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}

	}


}
