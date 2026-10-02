public class Stack<T> {

        private T[] data;
        private int top;

        @SuppressWarnings("unchecked")
        public Stack(int arraySize){
            if(arraySize < 1){
                arraySize = 1;
            }
            data = (T[]) new Object[arraySize];
            top = -1;
        }

        public void push(T newItem){
            if ( top == data.length - 1){
                resize();
            }
            data[++top] = newItem;
        }

        public T pop(){
            if ( top == -1){
                return null;
            }
            T item = data[top];
            data[top--] = null;
            return item;
        }

        public T peek(){
            if ( top ==  -1 ){
                return null;
            }
            return data[top];
        }

        @Override
        public String toString() {
            String result = "[";
            for (int i = 0; i <= top; i++){
                result += data[i];
                if (i < top) {
                    result += ", ";
                }
            }
            return result + "]";
        }

        public void display() {
            System.out.println(toString());
        }

        @SuppressWarnings("unchecked")
        private void resize() {
            T[] bigger = (T[]) new Object[data.length * 2];
            for(int i = 0; i <= top; i++){
                bigger[i] = data[i];
            }
            data = bigger;
        }
    }


