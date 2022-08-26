package len.cloud02.blog.po.cluster;

public class ServerStateDynamic_vmstat {
    private int procs_r;  // 等待执行的任务数
    private int procs_b;  //
    private int mem_swpd;  // 正在使用的swap大小单位K
    private int mem_free;  // 空闲的内存空间
    private int mem_buff;  // 已使用的buff大小，对块设备的读写进行缓冲
    private int mem_cache;  // 已使用的cache大小，文件系统的cache
    private int swap_si;  // 交换内存使用，由磁盘调入内存
    private int swap_so;  // 交换内存使用，由内存调入磁盘
    private int io_bi;  // read; 写入到块设备的数据总理(写磁盘) (KB/s)
    private int io_bo;  // write; 写入到块设备的数据总理(写磁盘) (KB/s)
    private int sys_in;  // 每秒产生的中断次数
    private int sys_cs;  // 每秒产生的上下文切换次数; 上面这2个值越大, 会看到由内核消耗的CPU时间会越多
    private int cpu_us;  // 用户进程消耗的CPU时间百分比
    private int cpu_sy;  // 内核进程消耗的CPU时间百分比
    private int cpu_id;  //
    private int cpu_wa;  // IO等待消耗的CPU时间百分比
    private int cpu_st;  //

    public ServerStateDynamic_vmstat() {
    }

    public int getProcs_r() {
        return procs_r;
    }

    public void setProcs_r(int procs_r) {
        this.procs_r = procs_r;
    }

    public int getProcs_b() {
        return procs_b;
    }

    public void setProcs_b(int procs_b) {
        this.procs_b = procs_b;
    }

    public int getMem_swpd() {
        return mem_swpd;
    }

    public void setMem_swpd(int mem_swpd) {
        this.mem_swpd = mem_swpd;
    }

    public int getMem_free() {
        return mem_free;
    }

    public void setMem_free(int mem_free) {
        this.mem_free = mem_free;
    }

    public int getMem_buff() {
        return mem_buff;
    }

    public void setMem_buff(int mem_buff) {
        this.mem_buff = mem_buff;
    }

    public int getMem_cache() {
        return mem_cache;
    }

    public void setMem_cache(int mem_cache) {
        this.mem_cache = mem_cache;
    }

    public int getSwap_si() {
        return swap_si;
    }

    public void setSwap_si(int swap_si) {
        this.swap_si = swap_si;
    }

    public int getSwap_so() {
        return swap_so;
    }

    public void setSwap_so(int swap_so) {
        this.swap_so = swap_so;
    }

    public int getIo_bi() {
        return io_bi;
    }

    public void setIo_bi(int io_bi) {
        this.io_bi = io_bi;
    }

    public int getIo_bo() {
        return io_bo;
    }

    public void setIo_bo(int io_bo) {
        this.io_bo = io_bo;
    }

    public int getSys_in() {
        return sys_in;
    }

    public void setSys_in(int sys_in) {
        this.sys_in = sys_in;
    }

    public int getSys_cs() {
        return sys_cs;
    }

    public void setSys_cs(int sys_cs) {
        this.sys_cs = sys_cs;
    }

    public int getCpu_us() {
        return cpu_us;
    }

    public void setCpu_us(int cpu_us) {
        this.cpu_us = cpu_us;
    }

    public int getCpu_sy() {
        return cpu_sy;
    }

    public void setCpu_sy(int cpu_sy) {
        this.cpu_sy = cpu_sy;
    }

    public int getCpu_id() {
        return cpu_id;
    }

    public void setCpu_id(int cpu_id) {
        this.cpu_id = cpu_id;
    }

    public int getCpu_wa() {
        return cpu_wa;
    }

    public void setCpu_wa(int cpu_wa) {
        this.cpu_wa = cpu_wa;
    }

    public int getCpu_st() {
        return cpu_st;
    }

    public void setCpu_st(int cpu_st) {
        this.cpu_st = cpu_st;
    }

    @Override
    public String toString() {
        return "ServerStateDynamic_vmstat{" +
                "procs_r=" + procs_r +
                ", procs_b=" + procs_b +
                ", mem_swpd=" + mem_swpd +
                ", mem_free=" + mem_free +
                ", mem_buff=" + mem_buff +
                ", mem_cache=" + mem_cache +
                ", swap_si=" + swap_si +
                ", swap_so=" + swap_so +
                ", io_bi=" + io_bi +
                ", io_bo=" + io_bo +
                ", sys_in=" + sys_in +
                ", sys_cs=" + sys_cs +
                ", cpu_us=" + cpu_us +
                ", cpu_sy=" + cpu_sy +
                ", cpu_id=" + cpu_id +
                ", cpu_wa=" + cpu_wa +
                ", cpu_st=" + cpu_st +
                '}';
    }
}
