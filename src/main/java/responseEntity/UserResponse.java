package responseEntity;

public class UserResponse {
    private Data data;

    private Support support;

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }

    public Support getSupport ()
    {
        return support;
    }

    public void setSupport (Support support)
    {
        this.support = support;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", support = "+support+"]";
    }
}
