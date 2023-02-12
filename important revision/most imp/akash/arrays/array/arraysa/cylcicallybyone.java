public void rotate(int arr[], int n)
    {
        int temp = arr[n-1];
        
        int k = arr[0];
        for(int i = 1; i < n - 1; i++){
            int t  = arr[i];
            arr[i] = k;
            k = t;
        }
        
        arr[n-1] = k;
        arr[0] = temp;
    }