package pota_aps1;

import java.util.Random;


//Guilherme (21002514)
//Diony     (20781283)

public class POTA_APS1 
{  
    public static String BubbleSort(int[] vector)
    {
        double start = System.currentTimeMillis();
        int n = vector.length;
        int novoN;
        
        do 
        {
            novoN = 0;
            for (int i = 1; i <= n - 1; i++) 
            {
                if (vector[i - 1] > vector[i])
                {

                    vector[i] = vector[i - 1] + vector[i];
                    
                    vector[i - 1] = vector[i] - vector[i - 1];
                    
                    vector[i] = vector[i] - vector[i - 1];

                    novoN = i;
                }
            }
            n = novoN;
        } while (n > 0);
        
        double fim = System.currentTimeMillis() - start;
        

        return "\nTempo Bubble " + fim;
    }
    
    public static String InsertionSort(int[] vector)
    {
        double start = System.currentTimeMillis();
        
        int size = vector.length;
        
        for (int i = 1; i <= size - 1; i++)
        {
           int j = i;
           
           while(j > 0 && vector[j - 1] > vector[j])
           {
               int aux = vector[j - 1];
               
               vector[j - 1] = vector[j];
               
               vector[j] = aux;
               j--;
           }
        }
        
        double fim = System.currentTimeMillis() - start;
        

        return "\nTempo Insert " + fim;
    }
    
    public static String SelectionSort(int[] vector)
    {
        int smallest = 0;
        
        double start = System.currentTimeMillis();
        
        for (int i = 0; i < vector.length - 1; i++)
        {
            smallest = i;
            
            for (int j = i + 1; j < vector.length; j++) 
            {
                if (vector[j] < vector[smallest]) 
                {
                    smallest = j;
                }
            }

            int aux = vector[i];
            
            vector[i] = vector[smallest];
            
            vector[smallest] = aux;
        }
        
        double fim = System.currentTimeMillis() - start;
        

        
        return "\nTempo Select " + fim;
    }
    
    public static String CallMergeSort(int vector[])
    {
        
        double start = System.currentTimeMillis();
        
        
         MergeSort(vector, 0, (vector.length - 1));
        
        double fim = System.currentTimeMillis() - start;
        

        
        return "\nTempo Merge " + fim;
    }
    
    public static int[] MergeSort(int vector[], int head, int tail)
    {
        if (head < tail) 
        {
            int middle = (head + tail) / 2;
            
            MergeSort(vector, head, middle);
            
            MergeSort(vector, middle + 1, tail);
            
            Interim(vector, head, middle, tail);
        }
        
        return vector;
    }

    public static void Interim(int[] vector, int head, int middle, int tail) 
    {
        int[] vectorB = vector.clone();
        
        int i, j;

        for (i = head; i <= middle; i++) 
        {
            vectorB[i] = vector[i];
        }

        for (j = middle + 1; j <= tail; j++) 
        {
            vectorB[tail + middle + 1 - j] = vector[j];
        }

        i = head;
        
        j = tail;

        for (int k = head; k <= tail; k++)
        {
            if (vectorB[i] <= vectorB[j]) 
            {
                vector[k] = vectorB[i];
                
                i++;
            } 
            else 
            {
                vector[k] = vectorB[j];
                
                j--;
            }
        }
    }

    public static String CocktailSort(int[] vector)
    {
        double start = System.currentTimeMillis();
        
        boolean swapped;
        do 
        {
          swapped = false;
          for (int i =0; i<=  vector.length  - 2;i++) 
          {
            if (vector[ i ] > vector[ i + 1 ]) 
            {

              int temp = vector[i];
              vector[i] = vector[i+1];
              vector[i+1]=temp;
              swapped = true;
            }
          }
          
          if (!swapped) 
          {      
            break;
          }
          
          swapped = false;
          
          for (int i= vector.length - 2;i>=0;i--) 
          {
            if (vector[ i ] > vector[ i + 1 ])
            {
              int temp = vector[i];
              vector[i] = vector[i+1];
              vector[i+1]=temp;
              swapped = true;
            }
          }

        } while (swapped);
        
        double fim = System.currentTimeMillis() - start;
        

        
        return "\nTempo Cocktail " + fim;
    }
    
     public static String ShellSort(int[] vector) 
     {
        int valor;
        
        int gap = 1;
        
        double start = System.currentTimeMillis();
        
        while (gap < vector.length) 
        {
            gap = 3 * gap + 1;
        }
        while (gap > 1) 
        {
            gap /= 3;
            for (int i = gap; i < vector.length; i++) 
            {
                valor = vector[i];
                int j = i;
                while (j >= gap && valor < vector[j - gap]) 
                {
                    vector[j] = vector[j - gap];
                    j = j - gap;
                }
                vector[j] = valor;
            }
        }
        double fim = System.currentTimeMillis() - start;
        
        
        return "\nTempo Shell " + fim;

        
    }
    
    public static int[] random (int length)
    {
        int [] vector = new int[length];
        
        Random r = new Random();
        
        for (int i = 0; i < length; i++)
        {
            vector[i] = r.nextInt(50);    
        }
        
        return vector;
    }
    public static void main(String[] args)
    {
//        int[] Arr = {3, 54, 6, 7, 5, 9};
//        
//        MergeSort(Arr, 0, Arr.length - 1);
//        
//        System.out.println(BubbleSort(Arr));
        
        for (int i = 100; i < 1000000; i *= 10) 
        {
            
            System.out.println(BubbleSort(random(i)) + " - quantidade:" + i + "\n");
            System.out.println(CallMergeSort(random(i)) + " - quantidade:" + i + "\n");
            System.out.println(CocktailSort(random(i))+ " - quantidade:" + i + "\n");
            System.out.println(InsertionSort(random(i))+ " - quantidade:" + i + "\n");
            System.out.println(SelectionSort(random(i))+ " - quantidade:" + i + "\n");
            System.out.println(ShellSort(random(i))+ " - quantidade:" + i + "\n");
        }
        
        
    }
    
}
