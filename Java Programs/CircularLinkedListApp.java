class Node
    {
        public int data; // data item (key)
        public Node next; // next Node in list

        public Node(int id) // constructor
        {
            data = id;
        }
        public void displayLink() // displays the Node
        {
            System.out.print("{" + data + "} ");
        }
		
		public int getData()
		{
			return data;
		}
    } // end of class Node
    
    class CircularLinkedList
    {
        public Node head; // ref to first node on list
        private int count;
        
        public CircularLinkedList() // constructor
        {
            head = null; // no items on list yet
        }
        
        public boolean isEmpty() // true if list is empty
        {
            return (head == null);
        }
       

        public void append(int data)
        {
            count++;
            Node temp = new Node(data);
            if (head == null)
            {
                head = temp;
            }
            else
            {
                Node tp = head;
                while (tp.next != head)
                {
                    tp = tp.next;
                }
                tp.next = temp;
            }
            temp.next = head;
            System.out.println("\n Node added: " + data + "\n");
        }
        public void addBeg(int data)
        {
            count++;
            Node temp = new Node(data);
            if (head == null)
            {
                temp.next = temp;
            }
            else
            {
                Node tp = head;
                while (tp.next != head)
                {
                    tp = tp.next;
                }
                tp.next = temp;
                temp.next = head;
            }
            head = temp;
            //System.out.println("\n Node added: " + data + "\n");
        }

        public void sortAdd(int data)
        {
            if (head == null) addBeg(data);
            else if (data <= head.data) { addBeg(data); }
            else
            {
                Node tp;
                //temp=new Link(data);
                int pos = 1;
                tp = head.next;
                for (pos = 1; tp.data < data; pos++)
                {
                    //if (tp.next == head && tp.data < data) ++pos;
                    if (tp.equals(head)) break;
                    tp = tp.next;
                }

                addAt(pos, data);
            }
        }

        public void addElement(Node input1)
        {
            input1 = new Node(5);

            Node temp = input1;
            if (head == null)
            {
                temp.next = temp;
                head = temp;
                System.out.println("\n Node added: " + input1.data + "\n");
            }
            else if (input1.data <= head.data)
            {
                Node tp = head;
                while (tp.next != head)
                {
                    tp = tp.next;
                }
                tp.next = temp;
                temp.next = head;
                head = temp;
                System.out.println("\n Node added: " + input1.data + "\n");
            }
            else
            {
                Node temp1, tp;
                //temp=new Link(data);
                int pos = 1;
                tp = head.next;
                for (pos = 1; tp.data < input1.data; pos++)
                {
                    if (tp.next == head && tp.data < input1.data) ++pos;
                    if (tp.next == head) break;
                    tp = tp.next;
                }

                //Node temp, tp;
                temp1 = new Node(input1.data);
                --pos;
                tp = head;
                for (int i = 0; i < pos; i++)
                {
                    if (tp.next == head)
                        break;
                    tp = tp.next;
                }
                temp.next = tp.next;
                tp.next = temp;
                //System.out.println("\n Node added: " + input1.data + "\n");
                //count++;

            }
        }

        public void addAt(int pos, int data)
        {
            Node temp, tp;
            temp = new Node(data);
            --pos;
            tp = head;
            for (int i = 0; i < pos; i++)
            {
                if (tp.next == head)
                    break;
                tp = tp.next;
            }
            temp.next = tp.next;
            tp.next = temp;
            //System.out.println("\n Node added: " + data + "\n");
            count++;
        }

        public void displayList()
        {
            if (head == null)
                System.out.println("List is empty..");
            else
            {
                Node temp = head;
                System.out.println(" Displaying circular linked list: ");
                System.out.print(" " + temp.data);
                while (temp.next != head)
                {
                    System.out.print(" -> ");
                    temp = temp.next;
                    System.out.print(temp.data);
                }
                //temp=temp.next;
                System.out.println("\n Link Head: " + temp.next.data + " Nodes count: " + getCount());
            }
        }
        public void deleteAt(int position)
        {
            Node current = head;
            Node previous = head;
            for (int i = 0; i < position; i++)
            {
                if (current.next == head)
                    break;
                previous = current;
                current = current.next;
            }
            //System.out.println("\n Node deleted: " + current.data + "\n");
            if (position == 0)
                deleteFirst();
            else
                previous.next = current.next;
            count--;
        }

        public void deleteFirst()
        {
            Node temp = head;
            while (temp.next != head)
            {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
            count--;
        }
        public int getCount()
        {
            return count;
        }
		
		public void sortCircularLinkedList()
        {
            Node tempouter,tempinner;
            tempouter = tempinner = head;
            int pos;
            for (int i = 0; tempouter.next != head; i++)
            {
				tempinner=tempouter.next;
				for (int j = i+1; tempinner.next != head; j++)
				{				
					if (tempinner.getData() > tempouter.getData())
					{						
						deleteAt(j);
						sortAdd(tempinner.data);
					}                 
					tempinner = tempinner.next;
				}
				tempouter=tempouter.next;
            }
            
        }

    } // end of class CircularLinkedList
    
    class CircularLinkedListApp
    {
        public static void main(String[] args)
        {
            Node input = new Node(5);
            CircularLinkedList cll = new CircularLinkedList();
            cll.sortAdd(3);
            cll.sortAdd(5);
            cll.sortAdd(6);
            cll.sortAdd(9);
            cll.sortAdd(8);
            cll.sortAdd(11);
            cll.sortAdd(4);
            cll.sortAdd(2);
            cll.sortAdd(12);
            cll.sortAdd(7);
            cll.sortAdd(10);
            //cll.addElement(input);
            cll.displayList();
            cll.deleteAt(1); //index starts from zero
            System.out.println(" After deletion....");
            cll.displayList();
			cll.addBeg(9);
			cll.addBeg(7);
			cll.addBeg(8);
			System.out.println(" After random adding ....");
			cll.displayList();
            cll.sortCircularLinkedList();
			System.out.println(" After sorting the list ....");
			cll.displayList();
        } // end of main()
    } // end of class CircularLinkedListApp
    