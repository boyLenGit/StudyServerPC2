package len.cloud02.blog.po.cluster;

public class ServerStateDynamic {
    private int cpu_all_usage;
    private int mem_total;
    private int mem_usage;
    private int mem_free;
    private int mem_shared;
    private int mem_cache;
    private int mem_available;
    private int io_read;
    // progress_num

    public ServerStateDynamic() {
    }

    public int getCpu_all_usage() {
        return cpu_all_usage;
    }

    public void setCpu_all_usage(int cpu_all_usage) {
        this.cpu_all_usage = cpu_all_usage;
    }

    public int getMem_total() {
        return mem_total;
    }

    public void setMem_total(int mem_total) {
        this.mem_total = mem_total;
    }

    public int getMem_usage() {
        return mem_usage;
    }

    public void setMem_usage(int mem_usage) {
        this.mem_usage = mem_usage;
    }

    public int getMem_free() {
        return mem_free;
    }

    public void setMem_free(int mem_free) {
        this.mem_free = mem_free;
    }

    public int getMem_shared() {
        return mem_shared;
    }

    public void setMem_shared(int mem_shared) {
        this.mem_shared = mem_shared;
    }

    public int getMem_cache() {
        return mem_cache;
    }

    public void setMem_cache(int mem_cache) {
        this.mem_cache = mem_cache;
    }

    public int getMem_available() {
        return mem_available;
    }

    public void setMem_available(int mem_available) {
        this.mem_available = mem_available;
    }

    public int getIo_read() {
        return io_read;
    }

    public void setIo_read(int io_read) {
        this.io_read = io_read;
    }

    @Override
    public String toString() {
        return "ServerStateDynamic{" +
                "cpu_all_usage=" + cpu_all_usage +
                ", mem_total=" + mem_total +
                ", mem_usage=" + mem_usage +
                ", mem_free=" + mem_free +
                ", mem_shared=" + mem_shared +
                ", mem_cache=" + mem_cache +
                ", mem_available=" + mem_available +
                ", io_read=" + io_read +
                '}';
    }
}
